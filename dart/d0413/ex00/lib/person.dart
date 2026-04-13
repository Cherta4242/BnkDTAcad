class Person{
  // late String name;
  String? name;
  int? _age;  // private (언더바)
  
  Person();
  Person.name(this.name);

  Person.init(this.name, this._age);
  
  set age(int age) => _age = age;
  int get age => _age ?? 0;

}
