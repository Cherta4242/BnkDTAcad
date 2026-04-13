class User{
  String username;
  int age;

  // User({this.username = 'unknown', this.age = 0});
  User({required this.username, this.age = 0});

  @override
  String toString() => 'username: $username, age: $age';
  

}