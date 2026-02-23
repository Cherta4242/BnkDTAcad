const promise = new Promise((resolve, reject) => {
    console.log("executor 실행...");
    let obj = {msg : 'hello'};
    resolve("가나다");
    // reject(new Error);
});

console.log(promise);
promise.then((data) => {
    console.log(data);
});
console.log('--END--');
