import { Button } from "@mui/material"
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';

interface RedirectionButtonProps {
    route: string;
}

export const RedirectionButton = (
    { route }: RedirectionButtonProps
) => {
    return <Button 
            size="small" 
            variant="contained" 
            endIcon={<ArrowForwardIcon />}
            component="a" 
            target="_blank"
            href={route} 
          >
            Watch More
    </Button>;
}