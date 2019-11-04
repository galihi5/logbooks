import React, { Component } from 'react';
import Modal from 'components/Modal/Modal';
import Aux from 'hoc/Auxx/Auxx';
import AuthenticationService, { SESSION_TOKEN } from 'views-gaw/Login/service/AuthenticationService';

const withErrorHandler = (WrappedComponent, axios) => {
    return class extends Component {
        state = {
            error: null
        }

        componentWillMount() {
            this.reqInterceptor = axios.interceptors.request.use(req => {
                this.setState({ error: null });
                console.log("=== interceptors.request ===");
                console.log(req.headers);
                let token = sessionStorage.getItem(SESSION_TOKEN);
                req.headers.authorization = token;
                return req;
            });
            this.resInterceptor = axios.interceptors.response.use(res => {
                console.log("+++ interceptors.response +++");
                console.log(res.data);
                return res;
            }, error => {
                this.setState({ error: error });
            });
        }

        componentWillUnmount() {
            axios.interceptors.request.eject(this.reqInterceptor);
            axios.interceptors.response.eject(this.resInterceptor);
        }

        errorConfirmedhandler = () => {
            this.setState({ error: null });
        }

        render() {
            return (
                <Aux>
                    <Modal
                        show={this.state.error}
                        modalClosed={this.errorConfirmedhandler}>
                        {this.state.error ? this.state.error.message : null}
                    </Modal>
                    <WrappedComponent {...this.props} />
                </Aux>
            );
        }
    }
}

export default withErrorHandler;