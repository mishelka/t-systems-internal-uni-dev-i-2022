<?

// Rodne cisla ver. 1.0, uprava 21.2.2001

define ("Separator1", '.');
define ("Separator2", '-');
define ("Separator3", '/');
define ("Pocet_Formatov", 7); 
define ("Pocet_Separatorov",3);
define ("MUZ","Muz");                    // definovanie navratovej hodnoty pohlavia Muz
define ("ZENA", "Zena");                 // definovanie navratovej hodnoty pohlavia Zena
define ("Rok_Zmeny", 54);                // mysli sa 19xx
define ("Rok_Zavedenia", 11);            // predpokladany rok zavedenia rc, mysli sa 1911


// funkcia formatovania rod. cisla. Ocakava na vstupe v premennej rc len 9 alebo 10 ciferne cislo
// Vrati sformatovany retazec podla nasledujucich typov. Ak sa neuvedie format vrati to iste
// Mozne formaty:    0 = XX.XX.XX/XXXX  alebo  XX.XX.XX/XXX
//                   1 = XX-XX-XX/XXXX  alebo  XX-XX-XX/XXX
//                   2 = XX.XX.XX.XXXX  alebo  XX.XX.XX.XXX
//                   3 = XX-XX-XX-XXXX  alebo  XX-XX-XX-XXX
//                   4 = XXXXXX/XXXX    alebo  XXXXXX/XXX
//                   5 = XXXXXX-XXXX    alebo  XXXXXX-XXX
//                   6 = XXXXXXXXXX     alebo  XXXXXXXXX
function formatuj_rc($rc, $format=6)
{
 $nastav_separatory=false;                                           // pomocna log. premenna, ak true, su pouzivane separatory nastavene
 switch($format)
     {
       case 6: {                                                     // ak sa ziada len cislo
                 return $rc; break;                                  // neurobi nic a vrati len cislo
               }
       case 0: { $separ1=Separator1; $separ2=Separator3;             // nastavenie separatorov pre typ 0
                 $nastav_separatory=true;                            // nastavenie pomocne log. premennej, info o nastaveni separatorov
               }
       case 1: { if(!$nastav_separatory) { $separ1=Separator2; $separ2=Separator3;             // nastavenie separatorov pre typ 1
                                           $nastav_separatory=true; }                          // nastavenie pomocne log. premennej, info o nastaveni separatorov
               }
       case 2: { if(!$nastav_separatory) { $separ1=Separator1; $separ2=Separator1;             // nastavenie separatorov pre typ 2
                                           $nastav_separatory=true; }                          // nastavenie pomocne log. premennej, info o nastaveni separatorov
               }
       case 3: { if(!$nastav_separatory) { $separ1=Separator2; $separ2=Separator2;             // nastavenie separatorov pre typ 3
                                           $nastav_separatory=true; }                          // nastavenie pomocne log. premennej, info o nastaveni separatorov
                 $rcislo = $rc[0].$rc[1].$separ1.$rc[2].$rc[3].$separ1.$rc[4].$rc[5].$separ2.$rc[6].$rc[7].$rc[8];
                 if(strlen($rc)>9) $rcislo=$rcislo.$rc[9];

                 return $rcislo; break;
               }
       case 4: { $separ1=Separator3;                                 // nastavenie separatora pre typ 4
                 $nastav_separatory=true;                            // nastavenie pomocne log. premennej, info o nastaveni separatorov
               }
       case 5: { if(!$nastav_separatory) { $separ1=Separator2;       // nastavenie separatorov pre typ 5
                                           $nastav_separatory=true; }                          // nastavenie pomocne log. premennej, info o nastaveni separatorov
                 $rcislo = $rc[0].$rc[1].$rc[2].$rc[3].$rc[4].$rc[5].$separ1.$rc[6].$rc[7].$rc[8];
                 if(strlen($rc)>9) $rcislo=$rcislo.$rc[9];
                 return $rcislo; break;
               }
       default: return $rc;                                          // ak bol zly format vrati to iste
     }
}

// Funkcia konvertuje lubovolny format rodneho cisla na cislo len cislo z cifier (format 6)
function cislo_z_rc($rc)
{
  if(!(is_numeric($rc[2])))                        // konverzia prvych styroch typov na cislo
      {
                 $rcislo = $rc[0].$rc[1].$rc[3].$rc[4].$rc[6].$rc[7].$rc[9].$rc[10].$rc[11];
                 if(strlen($rc)>12) $rcislo=$rcislo.$rc[12];
                 return $rcislo; break;
       }
   elseif(!(is_numeric($rc[6])))                     // konverzia typov 4 a 5
      {          $rcislo = $rc[0].$rc[1].$rc[2].$rc[3].$rc[4].$rc[5].$rc[7].$rc[8].$rc[9];
                 if(strlen($rc)>10) $rcislo=$rcislo.$rc[10];

                 return $rcislo; break;
       }
   else return $rc;                                    // ak vstupil typ 6 vrat to iste
}

// Funkcia testuje v pripade, ze rc obsahuje len cisla alebo povolene separatory
// ci je rc v niektorom z podporovanych formatov. Vracia: True - format OK inak False
function test_format_rc($rc)
{
 $dlzka=strlen($rc);                                    // zisti dlzku vstupeneho rc
 $pocet=0;                                              // premenna poctu separatorov
 $separ_position[0]=0;                                  // zoznam, kde su separatory
 for($i=0; $i<$dlzka; $i++)                             // cyklus na zistenie poctu a umiestnenia separatorov
      if(($rc[$i]==Separator1) || ($rc[$i]==Separator2) || ($rc[$i]==Separator3)) //test na pripustne separatory
                 $separ_position[$pocet++]=$i;                                    // ak bol separator, uloz jeho poziciu $i a zvys pocet separatorov $pocet
 if ($pocet>Pocet_Separatorov) { return false; break;}  // ak je pocet separ. vacsi ako pripustny vrati False
 switch($pocet)
     { case 1: if($separ_position[0]==6) { return true; break; }  // ak je jeden separator, musi byt na 6. pozicii
               else { return false; break; }  
       case 2: { return false; break; }                           // ak su dva, je to nepripustne
       case 3: if(($separ_position[0]==2) && ($separ_position[1]==5) && ($separ_position[2]==8)) { return true; break; } // ak su tri, tak na 2,5,8 pozicii
               else { return false; break;}
       default: return true;                                      // ak je nula, vrati true
     }
}

// Funkcia testuje delitelnost prveho argumentu druhym. Vracia True ak je delitelne, inak False
// Ak je zly pocet argumentov, iny ako 2, vrati False
function test_delitelnosti ( $a, $b)
{
if (!(func_num_args()==2)) { return false; break; }   
$c = $a / $b;
if($c-floor($c)) return false;
else return true;
}



// Funkcia testu a formatovania nad rodnym cislom. Mozne formaty
// pozri funkciu formatuj_rc(). Prednastaveny format 4
// Upravi vlozene RC ako retazec. 
// Vrati  FALSE ak je to OK a upravi vlozene RC
//        TEXTOVY POPIS CHYBY ak je RC zle a neupravuje vstup
// Chyby: 0: = nulovy pocet argumentov fcie
//        1: = neznama pozadovana sluzba
//        2: = neznamy pozadovany format
//        3: = nespravna dlzka vstupeneho rc
//        4: = nespravne rc - iny ako povolene znaky
//        5: = nespravne rc - trojcislie za lomitkom po roku zmeny
//        6: = nespravne rc - nepripustny den
//        7: = nespravne rc - nepripustny mesiac
//        8: = nespravne rc - separatory na nepripustnych miestach alebo ich nespravny pocet
//        9: = nespravne rc - rc nedelitelne 11
function rodne_cislo(&$rodc, $format=10)
{
 $chyba = array ("Nula argumentov","Neznama sluzba","Neznamy format RC","Zla dlzka RC","Nepovolene znaky v RC","3 cisla za lomitkom po roku zmeny","Zly den v RC","Zly mesiac v RC","Povolene separatory na inych miestach v RC","RC nedelitelne 11");
 $dnimes = array (1=>31,28,31,30,31,30,31,31,30,31,30,31);
 $rc=$rodc;                                                           // vytvorenie pracovnej kopie RC
 
 if (!(func_num_args())) { return $chyba[0]; break; }                 // test nuloveho poctu arg
 settype ($rc,"string");                                              // pretypovanie vstupu ak treba
 $dlzka = strlen($rc);
 if ($dlzka<9) { return $chyba[3]; break; }                           // test na minimalnu dlzku rc
 $len_cisla=false;                                                    // log. premenna ak v retazci su len cisla
 $cisla_separatory=true;                                              // log. premenna ak su tam len cisla a predpokladane separatory 
 if(is_numeric($rc)) $len_cisla=true;                                 // test na to ci vstup je len cislo
 else {
         for ($i=0; $i<$dlzka; $i++)
         switch ($rc[$i]) 
                { case Separator1:                                     // testy na povolene separatory
                  case Separator2:
                  case Separator3: break;
                  default: if(is_numeric($rc[$i])) break;              // testy na cislicu
                           else $cisla_separatory=false;               // ak ine ako povol. separ. alebo cislica nastavi premennu na false
                }
        }
 if(!($len_cisla || $cisla_separatory)) { return $chyba[4]; break; }   // test na len cisla alebo cisla a povolene separ, inak vrati chybu           
 if($len_cisla && $dlzka>10) { return $chyba[3]; break; }              // ak je len cislo, test ci nema dlzku > 10 cislic
 if(!(test_format_rc($rc))) { return $chyba[8]; break; }               // test korektneho formatu ak su len povolene separatory, ich pocet a umiestnenie
 $inter_rc = cislo_z_rc($rc);                                          // konverzia pre vnutorne potreby len na ciselny format
 $cislorc = (double) $inter_rc;                                                 // konverzia rc na cislo
 if(!(test_delitelnosti($cislorc,11))) { return $chyba [9]; break; }                    // test delietelnosti na 11
 $dlzka=strlen($inter_rc);                                             // zistenie dlzky overeneho ciselneho retazca rc
 $rok=(int)($inter_rc[0].$inter_rc[1]);                                       // selekcia roku z rc
 $mes=(int)($inter_rc[2].$inter_rc[3]);                                       // selekcia mesiaca z rc
 $den=(int)($inter_rc[4].$inter_rc[5]);                                       // selekcia dna z rc
 if(($rok >= Rok_Zmeny) && ($dlzka<10)) {return $chyba[5]; break;}     // test na korektnost porad. cisla na stvorcislie po Roku Zmeny
 if((($mes>12) && ($mes<51)) || $mes>62 || $mes==0) { return $chyba[7]; break;}   // test mesiaca na korektnost
 if($mes>12) $mes -=50;                                                // ak je mesiac 51 a vyssie, upravi ciselnu hodnotu mesiaca
 if($rok<Rok_Zavedenia) $rok += 2000;                                  // ak je dvojcislie roku mensie ako rok zavedenia, potom prirata 2000
   else $rok +=1900;                                                   // ak je dvocislie roku vacsie alebo rovne roku zavedenia prirata 1900
 if(!($rok % 4 )) $dnimes[2]=29;                                       // test na priestupny rok, ak ano, upravi pocet dni na 29
 if($den==0 || ($den>$dnimes[$mes])) { return $chyba[6]; break;}       // test na den
 if ($format>(Pocet_Formatov-1))                                       // test na maximalny pocet formatov, ak vacsi
    { $rodc=formatuj_rc($inter_rc,4);                                  // formatuje na pozadovany format a vrati FALSE
      return false;
    }
 else return formatuj_rc($inter_rc,$format);                           // ak je korektne cislo formatu vrati sformatovany retazec RC 
}

 echo "Rodne cislo\n";
 $rodne="4452151781";          // tu mozete zmodifikovat vstupny retazec
 $rod = rodne_cislo($rodne);   // $rod = rodne_cislo($rodne,1);  mozne aj toto s definovanim vystupneho formatu
 echo "r.c.>  ".$rodne."\nchyba> ".$rod."\n";
 
?>
