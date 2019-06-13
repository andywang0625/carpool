"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const React = require("react");
const ReactDOM = require("react-dom");
const App_1 = require("./App");
const core_1 = require("@material-ui/core");
const theme_1 = require("./config/theme");
ReactDOM.render(<core_1.MuiThemeProvider theme={theme_1.theme}>
    <App_1.App />
  </core_1.MuiThemeProvider>, document.getElementById('root'));
//# sourceMappingURL=index.jsx.map