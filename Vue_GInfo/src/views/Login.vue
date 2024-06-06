<style scoped>
.common-layout {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
}

.el-container {
    height: 100%;
}

.el-header {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    height: 20%;
}

.el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    width: 40%;
}

.el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;


}
</style>
<template>
    <div class="common-layout">
        <el-container>
            <el-header>运动会成绩管理系统</el-header>
            <el-container>
              <el-aside>

                <div class="el-aside__logo"></div>


                <el-card style="max-width: 480px">
                  <template #header>
                    <div class="card-header">
                      <span>近期比赛</span>
                    </div>
                  </template>
                  <el-table :data="matchList" border style="width: 100%">

                    <el-table-column prop="name" label="赛事名称"/>
                    <el-table-column prop="description" label="赛事描述"/>
                    <el-table-column prop="date" label="赛事日期"/>

                  </el-table>
                  <template #footer>
                    <el-button type="success" plain @click="searchButton">成绩查询</el-button>
                  </template>
                </el-card>

              </el-aside>
              <el-main>
                <el-row class="row-bg" justify="center">

                  <!-- 登录表 -->
                  <el-form label-position=right label-width="auto" class="demo-form-inline" :model="registerData">
                    <br><br><br><br>
                    <el-form-item label="用户名">
                      <el-input v-model="registerData.username" style="width: 240px"
                                placeholder="Please input" clearable/>
                    </el-form-item>
                    <el-form-item label="密码">
                      <el-input v-model="registerData.password" style="width: 240px" type="password"
                                placeholder="Please input password" show-password/>
                    </el-form-item>
                    <div align="center">
                      <el-button type="success" plain @click="loginButton">登录</el-button>
                      <el-button type="primary" plain @click="dialogFormVisible = true"> 注册</el-button>
                      <el-dialog v-model="dialogFormVisible" title="教师注册" width="500">
                        <el-form :model="registerData" :rules="rules">
                          <el-form-item label="教师工号" :label-width="formLabelWidth" prop="teacherId">
                            <el-input v-model="registerData.teacherId" autocomplete="off"/>
                          </el-form-item>
                          <el-form-item label="用户名" :label-width="formLabelWidth" prop="username">
                            <el-input v-model="registerData.username" autocomplete="off"/>
                          </el-form-item>
                          <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
                            <el-input v-model="registerData.password" type="password" placeholder=""
                                      autocomplete="off" show-password/>
                          </el-form-item>
                          <el-form-item label="确认密码" :label-width="formLabelWidth" prop="repassword">
                            <el-input v-model="registerData.repassword" autocomplete="off"/>
                          </el-form-item>
                          <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
                            <el-input v-model="registerData.phone" autocomplete="off"/>
                          </el-form-item>
                          <el-form-item label="验证码" :label-width="formLabelWidth" prop="code">
                            <el-input v-model="registerData.code" autocomplete="off"/>
                          </el-form-item>

                        </el-form>
                        <template #footer>
                          <div class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取消</el-button>
                            <el-button type="primary" @click="registerButton">注册</el-button>
                          </div>
                        </template>
                      </el-dialog>

                    </div>

                  </el-form>
                    </el-row>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script lang="ts" setup>


import {ElMessage} from 'element-plus'

import {ref} from 'vue'

const dialogFormVisible = ref(false)
const formLabelWidth = '140px'
const registerData = ref({
  username: '',
  password: '',
  repassword: '',
  teacherId: '',
  phone: '',
  code: ''
})

//校验密码
const checkRePassword = (rule, value, callback) => {
  if (value == '')
    callback(new Error('密码不能为空'));
  else if (value != registerData.value.password)
    callback(new Error('密码错误'));
  else
    callback();
}

//表单校验
const rules = ({
  username: [
    {required: true, message: '输入用户名', trigger: 'blur',},
    {min: 5, max: 16, message: '长度为5-16', trigger: 'blur',}
  ],
  password: [
    {required: true, message: '输入密码', trigger: 'blur',},
    {min: 5, max: 16, message: '长度为5-16', trigger: 'blur',}
  ],
  repassword: [
    {validator: checkRePassword, trigger: 'blur',},

  ],
  teacherId: [],
  phone: [],
  code: []
})

import {userRegisterService, userLoginService} from "@/api/user.js";
import {useRouter} from 'vue-router';
import {useTokenStore} from "@/stores/token.js";
import {getMatchListService} from '@/api/match';

const registerButton = async () => {
  let result = await userRegisterService(registerData.value);
  ElMessage.success(result.message ? result.message : '注册成功')
}
const router = useRouter()
const tokenStore = useTokenStore()
const loginButton = async () => {
  let result = await userLoginService(registerData.value);
  tokenStore.setToken(result.data)
  ElMessage.success('登录成功')
  router.push('/home')
}
const searchButton = () => {

  router.push('/search')
}
const matchList = ref([{
  id: 1,
  matchId: 1,
  name: '2021年全国大学生运动会',
  description: '2021年全国大学生运动会',
  date: '2021-06-01'
}])
const getMatchList = async () => {
  let result = await getMatchListService();
  matchList.value = result.data;
}
getMatchList();
</script>
