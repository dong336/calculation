const select = document.querySelector('#select');

let selectedRate;
let selectedCurrency;

select.addEventListener('change', (event) => {
	const rate = document.querySelector('#rate');
	const selected = select.options[select.selectedIndex].value;

	switch(selected){
	case 'KRW':
		rate.innerText = BODY.USDKRW + ' KRW/USD';
		selectedCurrency = 'KRW';
		selectedRate = BODY.USDKRW;
		break;
	case 'JPY':
		rate.innerText = BODY.USDJPY + ' JPY/USD';
		selectedCurrency = 'JPY';
		selectedRate = BODY.USDJPY;
		break;
	case 'PHP':
		rate.innerText = BODY.USDPHP + ' PHP/USD';
		selectedCurrency = 'PHP';
		selectedRate = BODY.USDPHP;
		break;
	}
});

const button = document.querySelector('#transfer');
const amount = document.querySelector('#amount');

button.addEventListener('click', (event) => {
	const message = document.querySelector('#message');
	
	if(HEADER.code != 'SUCCESS'){
		message.innerText = '시스템 오류가 발생하였습니다.';
	} else {
		let params = {
				"amount": amount.value,
				"rate": selectedRate,
				"state": select.options[select.selectedIndex].value
		};
		let xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function() {
	    	let response;
	        if (xhr.readyState === xhr.DONE) {
				console.log(xhr.response);
	            if (xhr.status === 200) {
	            	response = JSON.parse(xhr.responseText);
	            	
	            	if(response.header.code != 'SUCCESS'){
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
	    
	    xhr.open('POST', requestURI);
		xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	    xhr.send(JSON.stringify(params));
	    
	}
});