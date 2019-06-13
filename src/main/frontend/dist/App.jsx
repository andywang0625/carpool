"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const React = require("react");
const recompose_1 = require("recompose");
const core_1 = require("@material-ui/core");
class AppBase extends React.Component {
    constructor() {
        super(...arguments);
        this.render = () => {
            const { classes } = this.props;
            return <core_1.Typography>Hello World</core_1.Typography>;
        };
    }
}
exports.App = recompose_1.compose(core_1.withStyles((theme) => core_1.createStyles({
    root: {},
})))(AppBase);
//# sourceMappingURL=App.jsx.map