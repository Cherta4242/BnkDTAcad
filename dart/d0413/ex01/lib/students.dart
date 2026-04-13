class Student{
  String name;
  int kor;
  int eng;
  int math;
    
  Student(this.name, this.kor, this.eng, this.math);


  String average(){
    double avg = (kor + eng + math) / 3;

    if(avg >= 90){
      return 'A';
    }else if(avg >= 80){
      return 'B';
    }else if(avg >= 70){
      return 'C';
    }else if(avg >= 60){
      return 'D';
    }else if(avg >= 50){
      return 'E';
    }else{
      return 'F';
    }
  }

  int sum(Student student){
    return kor + eng + math;
  }

  @override
  String toString() => 'name: $name, kor: $kor, eng: $eng, math: $math';


}