import { connect } from 'react-redux';
import { setActiveLanguage } from 'react-localize-redux';

import LocalizeBox from './../components/controls/LocalizeBox';

const mapStateToProps = (state) => {
    return {
        languages : state.locale.languages
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        changeLanguage : (value) => dispatch(setActiveLanguage(value))
    }
};

export default connect(
    mapStateToProps,
    mapDispatchToProps)
(LocalizeBox);