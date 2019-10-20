import * as actionTypes from 'store/actions/actionTypes';
import { updateObject } from 'store/Utility';

const initialState = {
    error: null,
    routes: [],
    routesLoading: false,
    routesLoaded: false
}

const initRoutesStart = (state, action) => {
    return updateObject(state, { error: null, routesLoading: true, routesLoaded: false });
}

const initRoutesFail = (state, action) => {
    return updateObject(state, { error: action.error, routesLoading: false, routesLoaded: false });
}

const initRoutesSuccess = (state, action) => {
    return updateObject(state, { error: null, routes: action.routes, routesLoading: false, routesLoaded: true });
}

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.INIT_ROUTES_START: return initRoutesStart(state, action);
        case actionTypes.INIT_ROUTES_SUCCESS: return initRoutesSuccess(state, action);
        case actionTypes.INIT_ROUTES_FAIL: return initRoutesFail(state, action);
        default: return state;
    }
}

export default reducer;