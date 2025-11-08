@file:JsModule("material-icons-react")
@file:JsNonModule

package materialicons

import react.RClass
import react.RProps

@JsName("default")
external val materialIcon: RClass<MaterialIconProps>

external interface MaterialIconProps : RProps {
    var icon: String
    var size: Int
}

/*MaterialIcon.propTypes = {
    icon: PropTypes.string.isRequired,
    size: PropTypes.oneOfType([PropTypes.number, PropTypes.string]),
    invert: PropTypes.bool,
    inactive: PropTypes.bool
}*/