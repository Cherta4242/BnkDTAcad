console.log('hello');
const demo = document.querySelector('#demo');
demo.textContent = 'hello';
let user = {
    no: 1,
    id: 'aaa',
    name: 'James'
}

// 객체 리터널
console.log(user);
console.log(user.no);
console.log(user.id);
console.log(user.name);

let jUser = JSON.stringify(user);
console.log(jUser);
let user2 = JSON.parse(jUser);
console.log(user2);