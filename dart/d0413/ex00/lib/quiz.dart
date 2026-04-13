
import 'dart:io';

// test함수 - 매개변수 1: 필수 매개변수(int), 매개변수 2: 필수 매개변수(널 허용: 문자열)
void test(int i, String? s){
  stdout.write(i);
  stdout.write(" ");
  stdout.write(s);
}
// test함수 - 매개변수 1: 필수 매개변수(int), 매개변수 2: 선택 매개변수(널 허용: 문자열)
void test2(int i, {String? s}){
  stdout.write(i);
  stdout.write(" ");
  stdout.write(s);
}

// test함수 - 매개변수 1: 필수 매개변수(int), 매개변수 2: 네임드 파라미터(필수, 널허용), 매개변수 3: 네임드 파라미터(필수, 기본값 true)

void test3(int i, {required String? s, ss = "true"}){
  stdout.write(i);
  stdout.write(" ");
  stdout.write("$s");
  stdout.write(" ");
  stdout.write("$ss");
}

void chkString(String s){
  String ss = "";
  int n = s.length;
  stdout.writeln(s.length);
  for(int i = 0; i < n; i++){
    ss = ss + s.substring(s.length - 1 - i, s.length - i);
  }
  if(s == ss){
    stdout.write("회문입니다");
  }else{
    stdout.write("회문이 아닙니다.");
  }
}


void fizzBuzzBang(){
  for(int i = 1; i <= 105; i++){
    stdout.write(i);
    stdout.write(" ");
    if(i % 3 == 0){
      stdout.write("Fizz");
    }
    if(i % 5 == 0){
      stdout.write("Buzz");
    }
    if(i % 7 == 0){
      stdout.write("Bang");
    }
    stdout.writeln();
  }
}


void star(int n){
  String? spaceing = " ";
  int h = 0;

  for(int i = 1; i <= n; i++){
  stdout.write((spaceing * (n-i)) + ("*" * (i+h)));
  h++;
  
  stdout.writeln();
  }
}



// 필수 매개변수(required positional parameter)
int f(int n1, int n2){
  return n1 + n2;
}

// 선택 매개변수(optional positional parameter)
int f1(int n1, [int n2 = 1]){
  return n1 + n2;
}
int plus(int a1, [int a2 = 0]){
  return a1 + a2;
}


