import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://p090dh077:8080/'
});

export default instance;