const select = document.querySelector('#select');

let selectedRate;
let selectedCurrency;

select.addEventListener('change', (event) => {
	const rate = document.querySelector('#rate');
	const selected = select.options[select.selectedIndex].value;

	switch(selected){
	case 'KRW':
		rate.innerText = data.body.USDKRW + ' KRW/USD';
		selectedCurrency = 'KRW';
		selectedRate = data.body.USDKRW;
		break;
	case 'JPY':
		rate.innerText = data.body.USDJPY + ' JPY/USD';
		selectedCurrency = 'JPY';
		selectedRate = data.body.USDJPY;
		break;
	case 'PHP':
		rate.innerText = data.body.USDPHP + ' PHP/USD';
		selectedCurrency = 'PHP';
		selectedRate = data.body.USDPHP;
		break;
	}
});

const button = document.querySelector('#transfer');
const amount = document.querySelector('#amount');

button.addEventListener('click', (event) => {
	const message = document.querySelector('#message');
	
	if(data.code != 'SUCCESS'){
		message.innerText = '시스템 오류가 발생하였습니다.';
	} else {
		let params = {
				"amount": amount.value,
				"rate": selectedRate,
				"state": select.options[select.selectedIndex].value
		};
/* 		console.log(params); */
		let xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function() {
	    	let response;
	        if (xhr.readyState === xhr.DONE) {
	            if (xhr.status === 200) {
	            	response = JSON.parse(xhr.responseText);
	            	if(response.code != 'SUCCESS'){
	            		message.style.color = 'red';
	            	} else {
						message.style.color = 'black';
					}
	            	message.innerText = response.body;
	            } else {
	                console.error(xhr.responseText);
	            }
	        }
	    };
	    xhr.open('POST', 'http://192.168.0.106:8080/amount/receive');
		xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	    xhr.send(JSON.stringify(params));
	}
});