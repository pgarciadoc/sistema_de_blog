import axios from "axios";

const api = axios.create({
    baseURL: 'https://api.notion.com/v1/databases/20b4b12fed588090a07bf1548ba9f5cc/query'
})

export default api;