import { Box, Typography } from '@mui/material';

type PrototypePageProps = {
  title: string;
};

function PrototypePage({ title }: PrototypePageProps) {
  return (
    <Box>
      <Typography
        variant="h4"
        component="h1"
        sx={{
          color: 'primary.dark',
          fontWeight: 700,
          mb: 2,
        }}
      >
        {title}
      </Typography>

      <Typography
        variant="body1"
        color="text.secondary"
      >
        This screen will be implemented in a later milestone.
      </Typography>
    </Box>
  );
}

export default PrototypePage;