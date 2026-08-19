import {
  Box,
  Button,
  Chip,
  Paper,
  Stack,
  Typography,
} from '@mui/material';

import { useNavigate } from 'react-router';

function PendingReviewsPage() {
  const navigate = useNavigate();
  const STATUS_CHIP_WIDTH = 100;

  return (
    <Stack spacing={2}>
      <Box>
        <Typography
          variant="h4"
          component="h1"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
          }}
        >
          Pending Reviews
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
          sx={{
            mt: 0.5,
          }}
        >
          Review reconciliations submitted for Level-1 approval.
        </Typography>
      </Box>

      <Paper
        elevation={0}
        sx={{
          border: 1,
          borderColor: 'divider',
          borderRadius: 2,
          overflow: 'hidden',
        }}
      >
        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns:
              '1.1fr 1.3fr 1fr 1fr 1fr 1fr 140px',
            gap: 2,
            px: 2,
            py: 1.5,
            backgroundColor: 'background.default',
            borderBottom: 1,
            borderColor: 'divider',
          }}
        >
          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Employee
          </Typography>

          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Station
          </Typography>

          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Shift
          </Typography>

          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Sales
          </Typography>

          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Collections
          </Typography>

          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Status
          </Typography>

          <Typography variant="body2" sx={{ fontWeight: 700 }}>
            Action
          </Typography>
        </Box>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns:
              '1.1fr 1.3fr 1fr 1fr 1fr 1fr 140px',
            gap: 2,
            px: 2,
            py: 1.75,
            alignItems: 'center',
          }}
        >
          <Typography variant="body2" sx={{ fontWeight: 600 }}>
            Sujith
          </Typography>

          <Typography variant="body2">
            Demo Station
          </Typography>

          <Typography variant="body2">
            Shift 1
          </Typography>

          <Typography variant="body2">
            ₹ 43,250
          </Typography>

          <Typography variant="body2">
            ₹ 42,750
          </Typography>

		  <Chip
		    label="SHORTAGE"
		    color="error"
		    size="small"
		    sx={{
		      justifySelf: 'start',
		      width: STATUS_CHIP_WIDTH,
		    }}
		  />

          <Button
            variant="contained"
            size="small"
            onClick={() =>
              navigate('/app/reviews/pending/detail')
            }
          >
            Review
          </Button>
        </Box>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns:
              '1.1fr 1.3fr 1fr 1fr 1fr 1fr 140px',
            gap: 2,
            px: 2,
            py: 1.75,
            alignItems: 'center',
            borderTop: 1,
            borderColor: 'divider',
          }}
        >
          <Typography variant="body2" sx={{ fontWeight: 600 }}>
            Sonu
          </Typography>

          <Typography variant="body2">
            Demo Station
          </Typography>

          <Typography variant="body2">
            Shift 2
          </Typography>

          <Typography variant="body2">
            ₹ 39,800
          </Typography>

          <Typography variant="body2">
            ₹ 39,800
          </Typography>

		  <Chip
		    label="MATCHED"
		    color="success"
		    size="small"
		    sx={{
		      justifySelf: 'start',
		      width: STATUS_CHIP_WIDTH,
		    }}
		  />

          <Button
            variant="contained"
            size="small"
            onClick={() =>
              navigate('/app/reviews/pending/detail')
            }
          >
            Review
          </Button>
        </Box>
      </Paper>
    </Stack>
  );
}

export default PendingReviewsPage;