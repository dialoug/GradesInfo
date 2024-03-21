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
            <el-header>Header</el-header>
            <el-container>
                <el-aside>Aside</el-aside>
                <el-main>
                    <el-row class="row-bg" justify="center">


                        <el-form label-position=right label-width="auto" :model="formLabelAlign"
                            class="demo-form-inline">
                            <el-form-item label="用户名">
                                <el-input v-model="input" style="width: 240px" placeholder="Please input" clearable />
                            </el-form-item>
                            <el-form-item label="密码">
                                <el-input v-model="input" style="width: 240px" type="password"
                                    placeholder="Please input password" show-password />
                            </el-form-item>
                            <el-form-item>
                                <el-button type="success" plain>登录</el-button>
                                <el-button type="primary" plain>注册</el-button>
                            </el-form-item>

                        </el-form>
                    </el-row>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
const input = ref('')
import { reactive } from 'vue'

const formInline = reactive({
    user: '',
    region: '',
    date: '',
})

const onSubmit = () => {
    console.log('submit!')
}
</script>
