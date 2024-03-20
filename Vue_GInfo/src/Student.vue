<script setup>
import axios from "axios";
import { ref } from "vue";
const StudentList = ref([])

axios.get('/api/student')
    .then((result) => {
        StudentList.value = result.data.data;
        console.log(result.data);

        console.log(StudentList.value);
    }).catch((err) => {
        console.error();
    });

</script>


<template>
    <div>
        文章分类 <input type="text">
        发布状态 <input type="text">
        <button>
            搜索
        </button>
        <br />
        <br />
        <table border="1 solid" colspa="0" cellspacing="0">
            <tr>
                <th>文</th>
                <th>分类</th>
                <th>发表时间 </th>
                <th>状态 </th>
                <th>操作</th>
            </tr>

            <tr v-for="(Student, index) in StudentList">

                <td>{{ Student.studentName }}</td>
                <td>{{ Student.studentId }}</td>
                <td>{{ Student.gender }}</td>
                <td>{{ Student.classId }}</td>
                <td>
                    <button>编辑</button>
                    <button> 删除 </button>
                </td>
            </tr>
        </table>
    </div>
</template>
<style></style>