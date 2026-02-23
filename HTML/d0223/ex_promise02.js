const promise = new Promise((resolve, reject)=>{
    console.log('executor실행...');
    // 비동기 함수
    setTimeout(() => {
        const data = "hello~";
        if(data != null){
            console.log("서버 통신 성공");
            resolve(data);
        }else{
            console.log("서버 통신 실패...");
            reject(new Error('error.....'));
        }
    }, 1000);
});

console.log(promise);
promise.then((result) =>{
    console.log(result);
});


console.log(promise);
promise
    .then((result) =>{
        console.log(result);
    })
    .catch((error)=>{
        console.log('error가 났어요.');
    })
    .finally(()=>{
        console.log('finally----------');
    });

console.log('--END--');