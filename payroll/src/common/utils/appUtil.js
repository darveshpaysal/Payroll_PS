
export function log(error, info = '') {
    console.log(error, info);
};

export const stringifyJSON = (value) => {
	return JSON.stringify(value);
};

export const parseJSON = (value) => {
	return JSON.parse(value);
};

export const isBlank = (value) => {
	if (value === null || value === 'null' || value === undefined || value === 'undefined' || value === '') {
		return true;
	} else {
		return false;
	}
};

const getCurrentTime = () => {
	return new Date().toLocaleString().replace(",", "")
};

const toHex = (d) => {
    return ("0" + Number(d).toString(16)).slice(-2).toUpperCase()
}

const dectoHexAry = (iptAry) => {
	let ary = iptAry.map(i => String("0" + (Number(i).toString(16))).slice(-2).toUpperCase())
	return ary
};
  
const calCheckSum256 = (array) => {
	let sum = array.reduce((total, num) => (total + num))
	return sum % 256
};
  
const decimalToBinary = (d) => {
	var t = d.toString(2);
	while (t.length < 8) t = "0" + t;
	return String(t)
};
  
const  binaryToDecimal = d => {
	return parseInt(d, 2)
};
  
const dectoBinAry = (iptAry) => {
   let ary = iptAry.map(i => decimalToBinary(i))
	return ary
};
  
const addZero = (d) => {
	return 0 === String(d).length ? "00" : 1 === String(d).length ? "0" + String(d) : String(d)
};

const decimalToHex = (d) =>{
    for (var h = [], a = 0; a < d.byteLength; a++) h.push(toHex(d[a]));
    return h
}

const removeDuplicatesAryJsn = (arry) => {
	let jsonObject = arry.map(JSON.stringify);
	let uniqueSet = new Set(jsonObject);
	let uniqueArray = Array.from(uniqueSet).map(JSON.parse);
    return uniqueArray;
}

  //-----------------exporting---------//
  export {getCurrentTime,toHex,dectoHexAry,calCheckSum256,decimalToBinary,binaryToDecimal,dectoBinAry,decimalToHex,
	      addZero,removeDuplicatesAryJsn}
