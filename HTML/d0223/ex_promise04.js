fetch('https://jsonplaceholder.typicode.com/users')
    .then(response => response.json())
    .then((data) => {
        console.log(data);
    })
    .catch((error) => {
        console.log('에러 발생!!');
    })
    .finally(() => {
        console.log("마무~리");
    })