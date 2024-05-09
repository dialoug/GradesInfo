import './assets/main.css'
import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from "@/router";
import {createPinia} from "pinia";
import {createPersistedState} from "pinia-persistedstate-plugin";
import locale from "element-plus/dist/locale/zh-cn.js";

const app = createApp(App)
app.use(router)
app.use(ElementPlus, {locale})

const pinia = createPinia()
pinia.use(createPersistedState())
app.use(pinia)

app.mount('#app')
