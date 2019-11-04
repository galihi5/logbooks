import axios from 'axios-orders';

export const SESSION_USER = 'authenticatedUserId';
export const SESSION_TOKEN = 'jwtToken';

class AuthenticationService {
    executeJwtAuthenticationService(userid, password) {
        console.log(userid);
        return axios.post('/login', {
            userid,
            password
        });
    }

    registerSuccessfulLoginForJwt(userid, token) {
        sessionStorage.setItem(SESSION_USER, userid);
        sessionStorage.setItem(SESSION_TOKEN, token);
    }

    logout() {
        console.log("---before---" + sessionStorage.getItem(SESSION_USER) + " | " + sessionStorage.getItem(SESSION_TOKEN));
        sessionStorage.removeItem(SESSION_USER);
        sessionStorage.removeItem(SESSION_TOKEN);
        console.log("---after---" + sessionStorage.getItem(SESSION_USER) + " | " + sessionStorage.getItem(SESSION_TOKEN));
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem(SESSION_USER);
        let token = sessionStorage.getItem(SESSION_TOKEN);
        if (user === null || token === null) return false;
        return true;
    }

    getLoggedInUser() {
        let user = sessionStorage.getItem(SESSION_USER);
        if (user === null) return '';
        return user;
    }
}

export default new AuthenticationService();