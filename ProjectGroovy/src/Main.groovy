
class NoStrictType {
    static void myMethod1() {
        def a = 4.2
    }
}

class StrictType {
    void myMethod1() {
        int a = 4.2
    }
}

class NoReturn{
    Integer noretern(){
        int a = 5;
    }
}
Integer IntInt(Integer a){
    return a;
}
int intInt(Integer a){
    return a;
}
FirstClass firstClass = new FirstClass(15, "idfs");
//при создании явного конструктора данный код не работает
//Binding binding = new Binding("first", firstClass);
println(firstClass.getAnInt())
String str = "fsdf";
println(str instanceof Integer)
// Groovy позволяет нам сравнить String и Integer,
// java же еще на этапе компиляции выдает ошибку java: incompatible types: java.lang.String cannot be converted to java.lang.Integer
NoStrictType noStrictType = new NoStrictType();
StrictType strictType = new StrictType();
long begin = new Date().getTime();
for(int i = 0; i < 1000000; i++){
    noStrictType.myMethod1();
}
long end = new Date().getTime();
println(end-begin)//69, 64
begin = new Date().getTime();
for(int i = 0; i < 1000000; i++){
    strictType.myMethod1();
}
end = new Date().getTime();
println(end-begin)//99, 102, 90
//если посмотреть на байткод операций noStrictType.myMethod1() и strictType.myMethod1(),
//можно заметить что во второй функции в отличие от первой вызывается DefaultTypeTransformation.intUnbox()
//этот метод конвертирует объект-ссылку в в объект типа Number, и возвращает примитив. При этом затрачивая достаточно большое количество времени
//разница примерно в 1.5 раза.
NoReturn noReturn = new NoReturn();
println(noReturn.noretern());
//в Groovy даже без явного оператора return любой метод возвращает последнюю сссылку,
//сохраненную на вершине стека операндов на момент окончания работы метода.
println(IntInt(null))
//println(intInt(null)) //int не может быть null
BigDecimal first = new BigDecimal(15);
BigDecimal second = new BigDecimal(15);
println(first.equals(second));
//Если вы создадите два объекта с помощью ключевого слова new ,
//они никогда не будут указывать на одну и ту же ячейку памяти.
//В Java == означает равенство примитивных типов или идентичность для объектов. В Groovy == переводится в a.compareTo(b)==0 ,
// если они Comparable , и a.equals(b) в противном случае.
first.add(second);
first.multiply(second)
first.divide(second)
println(first); //
first += second;
first *= second;
first /= second;
println(first);
//в джаве BigDecimal является неизменяемым классом значение которого можно изменить лишь создав другой экземпляр
// поэтому все вышеперечисленное там не работает
//def a = 10
//println(a.getClass().getName()) //integer
//a = (char)'f'
//println(a.getClass().getName())// String, если добавить char перед значением, класс сменится на Character
//a = "fisdif"
//println(a.getClass().getName())//String
def a = 'f'
println(a.getClass().getName()) //String
a = 10
println(a.getClass().getName())// Integer
a = "fisdif"
println(a.getClass().getName())//String

Calendar calendar = new GregorianCalendar(2015, 1,28 )
Date date1 = calendar.getTime();
calendar = new GregorianCalendar(2015, 0, 31);
Date date2 = calendar.getTime();
println(date1 - date2); //28
date1.month -= 1;
println(date1) //Wed Jan 28 00:00:00 MSK 2015
date1.month += 1;
date1.date += 1;
println(date1)// Sun Mar 01 00:00:00 MSK 2015

int u = 45, x = 15, o = 5;
def divide( int u, int x, Closure cl ) {
    cl( u, x )
}

int v = divide( u, x ) { g, c -> g / c}
v = divide(v, o){g, c -> g - c}
println(v)