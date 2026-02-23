function getUserData(){
    console.log('getUserData...');
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();

        xhr.onload = function(){
            const result = xhr.responseText;
            resolve(result);
        }

        xhr.open("GET", "https://jsonplaceholder.typicode.com/users");
        xhr.send();
    });
}

getUserData().then((data) => {
    let result = JSON.parse(data);
    return result;
}).then((result) => {
    console.log('결과 : ', result[0]);
});