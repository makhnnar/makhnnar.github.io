import { 
  Card, 
  CardContent, 
  CardMedia, 
  Typography, 
  CardActions,
  Box
} from '@mui/material';

import "./cardItem.css";
import { ReactNode } from 'react';

interface CardItemProps {
    title: string;
    description: string;
    imageUrl: string;
    children: ReactNode
}

export const CardItem = ({ title, description, imageUrl, children }:CardItemProps) => {
  return <Card className="horizontal-card-root">
        <CardMedia
            component="img"
            className="horizontal-card-media"
            image={imageUrl}
            alt={title}
        />
        <Box className="horizontal-card-content-box">
            <CardContent className="horizontal-card-content">
                <Typography component="div" variant="h5" gutterBottom>
                    {title}
                </Typography>
                <Typography 
                    variant="body2" 
                    color="text.secondary"
                    className="horizontal-card-description"
                >
                    {description}
                </Typography>
            </CardContent>        
            <CardActions>
                {children}
            </CardActions>
        </Box>
    </Card>;
};



