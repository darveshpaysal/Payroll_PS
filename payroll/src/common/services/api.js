import axios from 'axios';

let apiurl =  'localhost:8080/rest/api/';
	//apiurl =  'https://d4yhfk2sq8.execute-api.us-east-1.amazonaws.com/vcare/';
	apiurl =  'https://gfstgvom2e.execute-api.us-east-1.amazonaws.com/vcareqa/';
	//apiurl = 'https://jfn0rqng7g.execute-api.us-east-1.amazonaws.com/vcare2/';

export default axios.create({
		baseURL: apiurl
});
