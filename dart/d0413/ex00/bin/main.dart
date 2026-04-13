// import 'package:ex01/ex01.dart' as ex01;

// import 'package:ex00/quiz.dart';
// import 'package:ex00/person.dart';

// import 'package:ex00/user.dart';
// import 'dart:io';

late String desc;

void main(List<String> arguments) {
  // print('Hello world: ${ex01.calculate()}!');
/*
  int? n;
  // n = 10;
  print(n);
*/


  // String? s;
  // s = 'hello';
  // ?? 문법 좌항이 null이면 오른쪽 항이 나옴
  // print(s ?? 's널입니다');

/*
  s ??= '널입니다';
  print(s);
*/


/*
  double? d;
  // d = 10.12;
  print(d);

  bool? tf;
  // tf = true;
  print(tf);
*/

/*
  String? nullableName = 'Alice';
  String name = nullableName!;
  print(name);
*/

/*
  desc = 'aaa';
*/

/*
  const int r = 10;
  final now = DateTime.now();
  final day = now.day;
  // day = 20;
*/
/*
  var x = 10;
  print(x);

  x = 'hello';

  dynamic y = 20;
  print(y);
  y = 'hello';
*/

/*
  Object a = 'hello';

  if(a is String){
    print('문자열');
  }
  
  if(a is! num){
    print('숫자 아님');
  }
  String b = a as String;
  print(b.toUpperCase());
*/
/*
  int xx = f(1, 2);
  print(xx);
*/

  // star(5);

  // fizzBuzzBang();

  // chkString("ololoo");

/*
  String? ss;
  test(10, ss);
  stdout.writeln();
  test2(20);
  stdout.writeln();
  test3(10, s:null, ss:false);
*/
/*
  var person = Person();
  person.name = 'James';

  print('person.name = ${person.name}');

  person.age = 10;
  print('person.age: ${person.age}');

  var person2 = Person.name('James');
  print(person2.name);
  Person person3 = Person.init("Ann", 30);
  print(person3.name);
  print(person3.age);
*/
/*
  var user = User(username:'aaa');
  var user2 = User(username: 'bbb', age:23);

  print(user.toString());

  print(user2.username);
  print(user2.age);
*/

/*
  var set2 = {'a', 'b', 'c'};
  set2.addAll({'e', 'f'});
  set2.remove('a');
  set2.removeAll({'b', 'c'});
  set2.contains('a');
  set2.contains('e');
  set2.containsAll({'e', 'f'});
  set2.clear();

  var set3 = {1, 2, 3};
  var set4 = {2, 3, 4};

  var union = set3.union(set4);
  print(union); // 합집합

  var intersection = set3.intersection(set4);
  print(intersection);  // 교집합

  var diffrence = set3.difference(set4);
  print(diffrence); // 차집합

  for(var item in set3){
    print(item);
  }

  set4.forEach((item) => print(item));

  List<int> nums = [1, 2, 2, 3, 4, 4, 5];

  var uniqueNums = nums.toSet();
  print(uniqueNums);  // {1, 2, 3, 4, 5}

  var setA = {1, 2, 3};
  var setB = {3, 2, 1};
  var setC = {1, 2, 3};
  print(setA == setB);  // false
  print(setA == setC);  // false
  print(setsEqual(setA, setB));   // true
  print(setsEqual(setA, setC));   // true
*/


  var map1 = Map();
  var map2 = Map<int, String>();
  Map<String, int> map3 = {};

  var person = {
    'name': 'Alice',
    'age': 10,
    'city': 'Busan'
  };
  print(person['name']);  // Alice
  print(person['gender']);  // null

  person['gender'] = 'man';
  print([person['gender']]);  // man

  person['name'] = 'James';
  print(person['name']);  // James

  var value = person['xxx'] ?? 'default';
  print(value); // default

  person.addAll({'phone': '010-1111-1111', 'hobby': 'reading'});
  print(person);  // {name: James, age: 10, city: Busan, gender: man, phone: 010-1111-1111, hobby: reading}

  person.remove('phone');
  print(person['phone']); // null

  print(person.containsKey('name'));  // true
  print(person.containsValue('woman')); // false

  person.forEach((key, value){
    print('key: $key, value: $value');
  });

  for(var key in person.keys){
    print(key);
  }

  for(var value in person.values){
    print(value);
  }

  var keyList = person.keys.toList();
  print(keyList);

  var valueList = person.values.toList();
  print(valueList);


}

bool setsEqual<T>(Set<T> a, Set<T> b){
  return a.length == b.length && a.containsAll(b);
}