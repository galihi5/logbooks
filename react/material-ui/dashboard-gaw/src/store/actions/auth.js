import axios from 'axios-orders';
import * as actionTypes from './actionTypes';
import { updateObject } from 'store/Utility';

// const USERNAME = 'gaw';
// const PASSWORD = 'gaw123'

export const initRoutesStart = () => {
    return {
        type: actionTypes.INIT_ROUTES_START
    }
}

export const initRoutesSuccess = (routes) => {
    return {
        type: actionTypes.INIT_ROUTES_SUCCESS,
        routes: routes
    }
}

export const initRoutesFail = (error) => {
    return {
        type: actionTypes.INIT_ROUTES_FAIL,
        error: error
    }
}


export const initRoutes = () => {
    return dispatch => {
        const routes = [];
        axios.get('/menus')
            .then(res => {
                for (let key in res.data) {
                    const updatedComponent = actionTypes.getComponent(res.data[key].component);
                    const updatedIcon = actionTypes.getIcon(res.data[key].icon);

                    const route = { ...res.data[key] }
                    const updatedViews = route.views.map((view, idx) => {
                        const updatedView = updateObject(view, { component: actionTypes.getComponent(view.component) });
                        return updatedView;
                    });
                    routes.push({
                        ...route,
                        component: updatedComponent,
                        icon: updatedIcon,
                        views: updatedViews,
                        id: key
                    });
                }
                dispatch(initRoutesSuccess(routes));
            })
            .catch(err => { 
                dispatch(initRoutesFail(err))
            });
    }
}
