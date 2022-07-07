package reflection;

public class AnnotationReflection {
    public static void main(String[] args) {
        Author author = Point.class.getAnnotation(Author.class);
        System.out.println("Author: " + author.name());
        System.out.println("Date: " + author.date());
    }
}
