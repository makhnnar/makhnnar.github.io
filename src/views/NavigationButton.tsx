import { Button } from "@mui/material"
import { Link } from "react-router-dom"
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';

interface NavigationButtonProps {
    route: string;
}

export const NavigationButton = (
    { route }: NavigationButtonProps
) => {
    return <Button 
            size="small" 
            variant="contained" 
            endIcon={<ArrowForwardIcon />}
            component={Link} 
            to={route} 
          >
            Watch More
    </Button>;
}