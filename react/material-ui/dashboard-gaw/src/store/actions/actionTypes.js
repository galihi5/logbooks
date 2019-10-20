//begin of routes
import Buttons from "views/Components/Buttons.js";
import Calendar from "views/Calendar/Calendar.js";
import Charts from "views/Charts/Charts.js";
import Dashboard from "views/Dashboard/Dashboard.js";
import ErrorPage from "views/Pages/ErrorPage.js";
import ExtendedForms from "views/Forms/ExtendedForms.js";
import ExtendedTables from "views/Tables/ExtendedTables.js";
import FullScreenMap from "views/Maps/FullScreenMap.js";
import GoogleMaps from "views/Maps/GoogleMaps.js";
import GridSystem from "views/Components/GridSystem.js";
import Icons from "views/Components/Icons.js";
import LockScreenPage from "views/Pages/LockScreenPage.js";
import LoginPage from "views/Pages/LoginPage.js";
import Notifications from "views/Components/Notifications.js";
import Panels from "views/Components/Panels.js";
import PricingPage from "views/Pages/PricingPage.js";
import ReactTables from "views/Tables/ReactTables.js";
import RegisterPage from "views/Pages/RegisterPage.js";
import RegularForms from "views/Forms/RegularForms.js";
import RegularTables from "views/Tables/RegularTables.js";
import SweetAlert from "views/Components/SweetAlert.js";
import TimelinePage from "views/Pages/Timeline.js";
import Typography from "views/Components/Typography.js";
import UserProfile from "views/Pages/UserProfile.js";
import ValidationForms from "views/Forms/ValidationForms.js";
import VectorMap from "views/Maps/VectorMap.js";
import Widgets from "views/Widgets/Widgets.js";
import Wizard from "views/Forms/Wizard.js";
import ReactTablesGaw from "views-gaw/Tables/ReactTables.js"; //views-gaw

// @material-ui/icons
import Apps from "@material-ui/icons/Apps";
import DashboardIcon from "@material-ui/icons/Dashboard";
import DateRange from "@material-ui/icons/DateRange";
import GridOn from "@material-ui/icons/GridOn";
import Image from "@material-ui/icons/Image";
import Place from "@material-ui/icons/Place";
import Timeline from "@material-ui/icons/Timeline";
import WidgetsIcon from "@material-ui/icons/Widgets";
import SentimentSatisfied from "@material-ui/icons/SentimentSatisfied";
import AndroidOutlined from "@material-ui/icons/AndroidOutlined";


// end of routes


export const getComponent = (strComponent) => {
    switch (strComponent) {
        case "Buttons": return Buttons;
        case "Calendar": return Calendar;
        case "Charts": return Charts;
        case "Dashboard": return Dashboard;
        case "ErrorPage": return ErrorPage;
        case "ExtendedForms": return ExtendedForms;
        case "ExtendedTables": return ExtendedTables;
        case "FullScreenMap": return FullScreenMap;
        case "GoogleMaps": return GoogleMaps;
        case "GridSystem": return GridSystem;
        case "Icons": return Icons;
        case "LockScreenPage": return LockScreenPage;
        case "LoginPage": return LoginPage;
        case "Notifications": return Notifications;
        case "Panels": return Panels;
        case "PricingPage": return PricingPage;
        case "ReactTables": return ReactTables;
        case "RegisterPage": return RegisterPage;
        case "RegularForms": return RegularForms;
        case "RegularTables": return RegularTables;
        case "SweetAlert": return SweetAlert;
        case "TimelinePage": return TimelinePage;
        case "Typography": return Typography;
        case "UserProfile": return UserProfile;
        case "ValidationForms": return ValidationForms;
        case "VectorMap": return VectorMap;
        case "Widgets": return Widgets;
        case "Wizard": return Wizard;
        case "ReactTablesGaw": return ReactTablesGaw;
        default: return null;
    }
}

export const getIcon = (strIcon) => {
    switch (strIcon) {
        case "Apps": return Apps;
        case "DashboardIcon": return DashboardIcon;
        case "DateRange": return DateRange;
        case "GridOn": return GridOn;
        case "Image": return Image;
        case "Place": return Place;
        case "Timeline": return Timeline;
        case "WidgetsIcon": return WidgetsIcon;
        case "AndroidOutlined": return AndroidOutlined;
        default: return SentimentSatisfied;
    }
}

export const INIT_ROUTES_START = 'INIT_ROUTES_START';
export const INIT_ROUTES_SUCCESS = 'INIT_ROUTES_SUCCESS';
export const INIT_ROUTES_FAIL = 'INIT_ROUTES_FAIL';

