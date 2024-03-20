import axios from 'axios';

export function GetStudentList() {
    axios({
        method:'get',
        url: "http://localhost:9090/student",
        data: {
            id:requestUrl
        }
    })
    
}