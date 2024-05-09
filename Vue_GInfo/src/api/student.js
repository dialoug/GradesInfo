import axios from 'axios';
import request from "@/utils/request.js";

export const getStudentListService = () => {
    //pinia响应数据不用.value
    return request.get('/student/list');
}

export const addStudentService = (addStudentData, classId) => {

    return request.put('/student/add?classId=' + classId, addStudentData);
}

export const updateStudentService = (studentId, classId) => {

    return request.put('/student/editClass?studentId=' + studentId + '&classId=' + classId);
}

export const deleteStudentService = (studentId) => {
    return request.post('/student/delete', studentId);
}