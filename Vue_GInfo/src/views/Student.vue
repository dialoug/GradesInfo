<style>
.demo-form-inline .el-select {
    --el-select-width: 220px;
}

.el-head {
    display: flex;
    justify-content: space-between;
}
</style>
<template>
  <el-main>
    <el-card>
      <div class="el-head">
        <span>学生列表</span>

        <el-upload ref="upload" class="upload-demo" action="/api/student/upload" :limit="1"
                   :on-exceed="handleExceed" :auto-upload="false" :headers="{ 'Authorization': tokenStore.token }"
                   :on-success="updateSuccess">
          <template #trigger>
            <el-button type="primary">选择学生信息文件</el-button>
          </template>

          <el-button class="ml-3" type="success" @click="submitUpload">
            上传
          </el-button>
          <template #tip>
            <div class="el-upload__tip text-red">
              limit 1 file, new file will cover the old file
            </div>
          </template>
        </el-upload>


      </div>
      <div style="height: 20px;"/>
      <hr>

      <el-form :inline="true" class="demo-form-inline">

        <el-form-item label="学院">
          <el-select v-model="academyId" placeholder="选择学院">
            <el-option v-for="academy in academyList" :label=academy.name :value=academy.academyId
                       @click='getClassList(); getTeacherListByAcademy();' clearable/>
          </el-select>
        </el-form-item>

        <el-form-item label="班级">
          <el-select v-model="classId" placeholder="选择班级">
            <el-option v-for="clas in classList" :label=clas.name :value=clas.classId clearable/>
          </el-select>
        </el-form-item>

        <el-form-item label="教师">
          <el-select v-model="teacherId" placeholder="选择教师">
            <el-option v-for="teacher in teacherList" :label=teacher.teacherName :value=teacher.teacherId
                       clearable/>
          </el-select>
        </el-form-item>

        <el-button type="primary" plain @click="addStudentForm = true; title = '添加学生信息'; clearData()">
          添加学生信息
        </el-button>

        <el-dialog v-model="addStudentForm" :title="title" width="500">
          <el-form :model="addStudentData" :rules="rules">

            <el-form-item label="学号" prop="studentId">
              <el-input v-model="addStudentData.studentId" autocomplete="off"/>
            </el-form-item>

            <el-form-item label="姓名" prop="studentName">
              <el-input v-model="addStudentData.studentName" autocomplete="off"/>
            </el-form-item>

            <el-form-item label="年龄" prop="age">
              <el-input v-model="addStudentData.age" autocomplete="off"/>
            </el-form-item>

            <el-form-item label="性别" prop="gender">
              <el-select v-model="addStudentData.gender" placeholder="选择性别" clearable>
                <el-option label="男" value="M"/>
                <el-option label="女" value="F"/>
              </el-select>
            </el-form-item>

            <el-form-item label="学院" prop="academy">
              <el-select v-model="academyId" placeholder="选择学院">
                <el-option v-for="academy in academyList" :label=academy.name :value=academy.academyId
                           @click='getClassList(); getTeacherListByAcademy();' clearable/>
              </el-select>
            </el-form-item>

            <el-form-item label="班级" prop="class">
              <el-select v-model="addStudentData.classId" placeholder="选择班级">

                <el-option v-for="clas in classList" :label=clas.name :value=clas.classId clearable/>
              </el-select>
            </el-form-item>

          </el-form>

          <template #footer>
            <div class="dialog-footer">
              <el-button @click="addStudentForm = false">取消</el-button>
              <el-button type="primary"
                         @click="title == '添加学生信息' ? addStudentButton() : editSubmitButton()">确定
              </el-button>
            </div>
          </template>

        </el-dialog>

        <el-form-item label="学号">
          <el-input v-model="searchId" style="width: 240px" placeholder="Please input" clearable/>
        </el-form-item>


        <el-form-item>
          <el-button type="primary" @click="searchButton">搜索</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="default" @click="resetButton">重置</el-button>
        </el-form-item>
      </el-form>

      <el-table :data="studentData" border style="width: 100%">
        <el-table-column prop="studentId" label="学号"/>
        <el-table-column prop="studentName" label="姓名"/>
        <el-table-column prop="gender" label="性别"/>
        <el-table-column prop="age" label="年龄"/>

        <el-table-column prop="teacher" label="教师"/>
        <el-table-column prop="academy" label="学院"/>
        <el-table-column prop="class" label="班级"/>


        <el-table-column prop="edit" label="Edit" width="200">
          <template #default="{ row }">
            <el-button type="primary" :icon="Edit" circle @click="editButton(row)"/>
            <el-button type="info" :icon="Message" circle/>
            <el-button type="danger" :icon="Delete" circle @click="deleteButton(row)"/>

          </template>
        </el-table-column>

      </el-table>
    </el-card>
  </el-main>

  <el-footer>

    <el-pagination v-model:current-page="currentPage" v-model:page-size="pageSize" :page-sizes="[10, 20, 30, 40]"
                   :small="small" :disabled="disabled" :background="background"
                   layout=" prev, pager, next,jumper,total, sizes"
                   :total="total" @size-change="handleSizeChange" @current-change="handleCurrentChange"/>

  </el-footer>

</template>



<script lang="ts" setup>

import {ref} from 'vue'
import {
  Check,
  Delete,
  Edit,
  Message,
  Search,
  Star,
} from '@element-plus/icons-vue'
import {
  getStudentListService,
  addStudentService,
  getStudentByClassIdService,
  updateStudentService,
  deleteStudentService,
  getStudentByStudentIdService,
  updateStudentExcelService,
} from "@/api/student.js";
import {
  getAcademyListService,
  getClassListByAcademyIdService,
  getClassByStudentIdService,
  getAcademyByclassIdService
} from "@/api/department.js";
import {getTeacherListService, getTeacherListByAcademyIdService} from "@/api/teacher.js";


import {ElMessage, ElMessageBox} from 'element-plus';

const addStudentForm = ref(false)

const title = ref('')

const currentPage = ref(1)
const pageSize = ref(10)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)
const total = ref(20)
const studentData = ref([
      {
        studentId: '5120201124',
        studentName: 'dasw',
        gender: '',
        age: '',
        teacher: '',
        academy: '',
        class: '',

      },
    ]
)
const addStudentData = ref(
    {
      studentId: '',
      studentName: '',
      gender: '',
      age: '',
      classId: '',
    },
)

const clearData = () => {
  addStudentData.value.age = '';
  addStudentData.value.classId = '';
  addStudentData.value.gender = '';
  addStudentData.value.studentName = '';
  addStudentData.value.studentId = ''
}

const addStudentButton = () => {

  addStudent()
}

const academyId = ref('')

const academyList = ref([
  {
    academyId: '',
    name: '',
    classNumber: '',
  }
])

const classId = ref('')

const classList = ref([
  {
    classId: '',
    name: '',
    studentNumber: '',
  }
])


const teacherId = ref('')
const teacherList = ref([
  {
    teacherId: '',
    teacherName: '',
  }
])


const searchId = ref('')

const setStudentClass = async (studentData) => {
  studentData.value.forEach(async (item, index) => {
    //ElMessage.success(item.classId)
    let reseltC = await getClassByStudentIdService(item.studentId);
    item.class = reseltC.data.name;
    item.classId = reseltC.data.classId;

    let reseltA = await getAcademyByclassIdService(item.classId);
    item.academy = reseltA.data.name;
    item.academyId = reseltA.data.academyId;
  });

}


const getAcademyList = async () => {
  let result = await getAcademyListService();
  academyList.value = result.data;
}
const getClassList = async () => {
  let result = await getClassListByAcademyIdService(academyId.value);
  classList.value = result.data;
}
const getTeacherList = async () => {
  let result = await getTeacherListService();
  teacherList.value = result.data;
}
const getTeacherListByAcademy = async () => {
  let result = await getTeacherListByAcademyIdService(academyId.value);
  teacherList.value = result.data;
}
getAcademyList();
getTeacherList();

//点击编辑按钮事件
const editButton = (rowData) => {
  addStudentForm.value = true;
  title.value = '编辑学生信息';

  addStudentData.value.studentId = rowData.studentId;
  addStudentData.value.studentName = rowData.studentName;
  addStudentData.value.age = rowData.age;
  addStudentData.value.gender = rowData.gender;

  addStudentData.value.classId = rowData.class;
  academyId.value = rowData.academy;

}
//查找班级通过学生信息
const searchButton = async () => {
  if (searchId.value === '') {
    let reselt = await getStudentByClassIdService(classId.value);
    studentData.value = reselt.data;
    setStudentClass(studentData);
  } else {

    let reselt = await getStudentByStudentIdService(searchId.value);
    studentData.value = reselt.data;

    setStudentClass(studentData);
  }

}
const resetButton = () => {

  getStudentList();
}
const uploadButton = () => {
  console.log('submit!')
}


const editSubmitButton = () => {
  editStudent();
  console.log('submit!')
}
const deleteButton = (rowData) => {
  ElMessageBox.confirm(
      '要删除该学生信息?',
      'Warning',
      {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
        type: 'warning',
      }
  )
      .then(() => {
        deleteStudent(rowData.studentId)
        ElMessage({
          type: 'success',
          message: '删除成功',
        })
      })
      .catch(() => {
        ElMessage({
          type: 'info',
          message: '取消删除',
        })
      })
}


const getStudentList = async () => {
  let result = await getStudentListService();
  studentData.value = result.data;
  setStudentClass(studentData)

}
getStudentList();

const addStudent = async () => {
  let result = await addStudentService(addStudentData.value, addStudentData.value.classId);
  ElMessage.success(result.data ? result.data : '添加成功')
  getStudentList();
  addStudentForm.value = false;
}
const deleteStudent = async (rowStudentId) => {
  let result = await deleteStudentService(rowStudentId);
  ElMessage.success(result.data ? result.data : '删除成功')
  getStudentList();
  addStudentForm.value = false;
}
const editStudent = async () => {
  let result = await updateStudentService(addStudentData.value.studentId, addStudentData.value.classId);
  ElMessage.success(result.data ? result.data : '修改成功')
  getStudentList();
  addStudentForm.value = false;
}


const rules = ({
  studentId: [
    {required: true, message: '输入学号', trigger: 'blur',},
    {min: 5, max: 16, message: '长度为5-16', trigger: 'blur',}
  ],
  studentName: [
    {required: true, message: '输入学生姓名', trigger: 'blur',},
    {min: 2, max: 16, message: '长度为2-16', trigger: 'blur',}
  ],
  age: [
    {required: true, message: '输入年龄', trigger: 'blur',},
  ],
  gender: [
    {required: true, message: '选择性别', trigger: 'change',}
  ],
  // academy: [
  //     { required: true, message: '选择学院', trigger: 'change' },
  // ],
  // class: [
  //     { required: true, message: '选择班级', trigger: 'change', type: 'string' },
  // ],
})

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
}

import {genFileId} from 'element-plus'
import type {UploadInstance, UploadProps, UploadRawFile} from 'element-plus'
import {useTokenStore} from '@/stores/token';

const tokenStore = useTokenStore();
const upload = ref<UploadInstance>()

const handleExceed: UploadProps['onExceed'] = (files) => {
  upload.value!.clearFiles()
  const file = files[0] as UploadRawFile
  ElMessage.success()
  file.uid = genFileId()
  upload.value!.handleStart(file)
}

const submitUpload = () => {
  //updateTranscriptsExcelService()
  upload.value!.submit()
}

const updateSuccess = async (result) => {
  ElMessage.success(result.data)
  let r = await updateStudentExcelService(result.data)
  ElMessage.success(r.data)
  getStudentList();
}

</script>
