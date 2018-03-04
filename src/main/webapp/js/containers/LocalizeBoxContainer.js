import { connect } from 'react-redux';

import LocalizeBox from './../components/controls/LocalizeBox';

const mapStateToProps = (state) => {
    return {
        languages : state.locale.languages
    };
};

export default connect(mapStateToProps)(LocalizeBox);