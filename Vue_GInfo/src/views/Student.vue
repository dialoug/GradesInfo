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

    <div class="common-layout">
        <el-container>
            <el-header>Header</el-header>
            <el-container>
                <el-aside width="200px">Aside</el-aside>
                <el-container>
                    <el-main>
                        <el-card>
                            <div class="el-head">
                                <span>学生信息</span>
                                <el-button type="primary" @click="onSubmit">上传学生信息</el-button>
                            </div>
                            <div style="height: 20px;" />
                            <hr>
                            <el-form :inline="true" :model="formInline" class="demo-form-inline">
                                <el-form-item label="学号">
                                    <el-select v-model="formInline.region" placeholder="选择班级" clearable>
                                        <el-option label="Zone one" value="shanghai" />
                                        <el-option label="Zone two" value="beijing" />
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="姓名">
                                    <el-select v-model="formInline.region" placeholder="Activity zone" clearable>
                                        <el-option label="Zone one" value="shanghai" />
                                        <el-option label="Zone two" value="beijing" />
                                    </el-select>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="onSubmit">搜索</el-button>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="default" @click="onSubmit">重置</el-button>
                                </el-form-item>
                            </el-form>

                            <el-table :data="tableData" border style="width: 100%">
                                <el-table-column prop="date" label="Date" width="180" />
                                <el-table-column prop="name" label="Name" width="80" />
                                <el-table-column prop="address" label="Address" />
                                <el-table-column prop="status" label="Status" width="80" />

                                <el-table-column prop="edit" label="Edit" width="200">
                                    <el-button type="primary" :icon="Edit" circle />
                                    <el-button type="info" :icon="Message" circle />
                                    <el-button type="danger" :icon="Delete" circle />
                                </el-table-column>

                            </el-table>
                        </el-card>
                    </el-main>
                    <el-footer>

                        <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4"
                            :page-sizes="[10, 20, 30, 40]" :small="small" :disabled="disabled" :background="background"
                            layout=" prev, pager, next,jumper,total, sizes" :total="total"
                            @size-change="handleSizeChange" @current-change="handleCurrentChange" />

                    </el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>



<script lang="ts" setup>

import { reactive } from 'vue'
import { ref } from 'vue'

const formInline = reactive({
    user: '',
    region: '',
    date: '',
})

const onSubmit = () => {
    console.log('submit!')
}



const currentPage4 = ref(1)
const pageSize4 = ref(10)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)
const total = ref(20)


const handleSizeChange = (val: number) => {
    console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
    console.log(`current page: ${val}`)
}

import {
    Check,
    Delete,
    Edit,
    Message,
    Search,
    Star,
} from '@element-plus/icons-vue'
const tableData = [
    {
        date: '2016-05-03',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-02',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-04',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-01',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-01',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    }, {
        date: '2016-05-01',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    }, {
        date: '2016-05-01',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    }
]


</script>
