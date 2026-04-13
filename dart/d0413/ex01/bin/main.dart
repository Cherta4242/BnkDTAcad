import 'package:dart_application_1/students.dart';

void main(List<String> arguments) {
  var student1 = Student('Cherta', 90, 80, 90);
  var student2 = Student('Lumina', 82, 99, 92);
  var student3 = Student('Jakarta', 100, 56, 12);
  var student4 = Student('Helion', 62, 50, 88);
  var student5 = Student('Onflick', 80, 94, 94);

  print('학생 ${student1.name}의 등급: ${student1.average()}');
  print('학생 ${student2.name}의 등급: ${student2.average()}');
  print('학생 ${student3.name}의 등급: ${student3.average()}');
  print('학생 ${student4.name}의 등급: ${student4.average()}');
  print('학생 ${student5.name}의 등급: ${student5.average()}');

}