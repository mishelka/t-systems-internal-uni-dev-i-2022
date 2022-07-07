package reflection.annotation;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access class.
 */
public class DataAccess {
    /**
     * Connection.
     */
    private Connection connection;

    /**
     * Field type.
     */
    private enum FieldType {
        ALL, PRIMARY_KEY, NOT_PRIMARY_KEY
    }
    
    /**
     * Debug flag.
     */
    public static final boolean debug = true;

    /**
     * Constructor. 
     * @param connection connection
     */
    public DataAccess(Connection connection) {
        this.connection = connection;
    }

    /**
     * Returns connection.
     * 
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Set connection.
     * 
     * @param connection
     *            connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Selects data.
     * 
     * @param <T> type of an instance
     * @param cl class of instances
     * @param condition SQL condition
     * @return list of selected instances
     */
    public <T> List<T> select(Class<T> cl, String condition)
            throws SQLException, InstantiationException, IllegalAccessException {
        Table table = cl.getAnnotation(Table.class);

        if (table != null) {
            List<Field> fields = getFields(cl, FieldType.ALL);
            StringBuilder sb = new StringBuilder("SELECT ");
            sb.append(getColumnNames(fields));
            sb.append(" FROM ");
            sb.append(table.name());
            if (condition != null) {
                sb.append(" " + condition);
            }

            if (debug) {
                System.out.println(sb.toString());
            }

            // Execute query and return list
            List<T> result = new ArrayList<T>();
            ResultSet rs = connection.prepareStatement(sb.toString()).executeQuery();
            while (rs.next()) {
                T object = cl.newInstance();
                int i = 1;
                for (Field field : fields) {
                    Object value = rs.getObject(i++);
                    field.setAccessible(true);
                    field.set(object, value);
                }
                result.add(object);
            }

            return result;
        } else {
            throw new RuntimeException("Class does not contain annotation table.");
        }
    }

    /**
     * Inserts object into database.
     * 
     * @param object object
     * @return number of inserted rows.
     */
    public int insert(Object object) throws SQLException,
            IllegalAccessException {
        Table table = object.getClass().getAnnotation(Table.class);

        if (table != null) {
            List<Field> fields = getFields(object.getClass(),
                    FieldType.ALL);

            StringBuilder sb = new StringBuilder("INSERT INTO ");
            sb.append(table.name());
            sb.append(" (");
            sb.append(getColumnNames(fields));
            sb.append(") VALUES (");

            // Add columns to insert
            boolean next = false;
            for (Field field : fields) {
                if (next) {
                    sb.append(",");
                }
                next = true;
                sb.append("?");
            }
            sb.append(")");

            // Get connection, set params and execute
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            int index = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null) {
                    ps.setObject(index++, value);
                } else {
                    ps.setString(index++, null);
                }
            }

            if (debug) {
                System.out.println(sb.toString());
            }

            return ps.executeUpdate();
        } else {
            throw new RuntimeException(
                    "Class does not contain annotation table.");
        }
    }

    /**
     * Updates object.
     * 
     * @param object object to update
     * @return number of updated rows.
     */
    public int update(Object object) throws SQLException,
            IllegalAccessException {
        Table table = object.getClass().getAnnotation(Table.class);

        if (table != null) {
            List<Field> fields = getFields(object.getClass(),
                    FieldType.NOT_PRIMARY_KEY);
            List<Field> pkFields = getFields(object.getClass(),
                    FieldType.PRIMARY_KEY);

            StringBuilder sb = new StringBuilder("UPDATE ");
            sb.append(table.name());
            sb.append(" SET ");

            // Add columns to update
            boolean next = false;
            for (Field field : fields) {
                if (next) {
                    sb.append(",");
                }
                next = true;
                sb.append(field.getAnnotation(Column.class).name());
                sb.append("=?");
            }

            // Add PK to WHERE condition
            sb.append(" WHERE ");
            next = false;
            for (Field field : pkFields) {
                if (next) {
                    sb.append(" AND ");
                }
                next = true;
                sb.append(field.getAnnotation(Column.class).name());
                sb.append("=?");
            }

            // Get connection, set params and execute
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            int index = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null) {
                    ps.setObject(index++, value);
                } else {
                    ps.setString(index++, null);
                }
            }
            for (Field field : pkFields) {
                field.setAccessible(true);
                ps.setObject(index++, field.get(object));
            }

            if (debug) {
                System.out.println(sb.toString());
            }

            return ps.executeUpdate();
        } else {
            throw new RuntimeException("Class does not contain annotation table.");
        }
    }

    /**
     * Deletes object.
     * 
     * @param object
     *            object to delete
     * @return number of deleted rows.
     */
    public int delete(Object object) throws SQLException,
            IllegalAccessException {
        Table table = object.getClass().getAnnotation(Table.class);

        if (table != null) {
            List<Field> pkFields = getFields(object.getClass(),
                    FieldType.PRIMARY_KEY);

            StringBuilder sb = new StringBuilder("DELETE FROM ");
            sb.append(table.name());
            sb.append(" WHERE ");

            // Add PK to WHERE condition
            boolean next = false;
            for (Field field : pkFields) {
                if (next) {
                    sb.append(" AND ");
                }
                next = true;
                sb.append(field.getAnnotation(Column.class).name());
                sb.append("=?");
            }

            // Get connection, set params and execute
            PreparedStatement ps = connection.prepareStatement(sb.toString());
            int index = 1;
            for (Field field : pkFields) {
                field.setAccessible(true);
                ps.setObject(index++, field.get(object));
            }

            if (debug) {
                System.out.println(sb.toString());
            }

            return ps.executeUpdate();
        } else {
            throw new RuntimeException("Class does not contain annotation table.");
        }
    }

    /**
     * List of fields from class with specified type.
     * 
     * @param <T> type
     * @param cl class of instance
     * @param fieldType type of fields
     * @return list of fields
     */
    private <T> List<Field> getFields(Class<T> cl, FieldType fieldType) {
        List<Field> fields = new ArrayList<Field>();

        for (Field field : cl.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                switch (fieldType) {
                    case ALL:
                        fields.add(field);
                        break;
                    case PRIMARY_KEY:
                        if (column.primaryKey()) {
                            fields.add(field);
                        }
                        break;
                    case NOT_PRIMARY_KEY:
                        if (!column.primaryKey()) {
                            fields.add(field);
                        }
                        break;
                }
            }
        }

        return fields;
    }

    /**
     * Returns column names from the list of fields.
     * 
     * @param fields list of fields
     * @return string with column names separated with comma.
     */
    private String getColumnNames(List<Field> fields) {
        StringBuilder sb = new StringBuilder();
        boolean next = false;

        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (next) {
                sb.append(",");
            }
            next = true;

            if (column != null) {
                sb.append(column.name());
            }
        }

        return sb.toString();
    }
}
