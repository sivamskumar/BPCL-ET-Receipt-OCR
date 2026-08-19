import CheckCircleOutlineOutlinedIcon
  from '@mui/icons-material/CheckCircleOutlineOutlined';
import ImageOutlinedIcon
  from '@mui/icons-material/ImageOutlined';

import {
  Box,
  Button,
  Chip,
  Paper,
  Stack,
  TextField,
  Typography,
} from '@mui/material';

import {
  useLocation,
  useNavigate,
} from 'react-router';

type OcrReviewState = {
  imageUrl?: string;
  fileName?: string;
  dispenserUnit?: string;
  dispenserSide?: string;
  receiptType?: string;
};

function OcrReviewPage() {
  const navigate = useNavigate();
  const location = useLocation();

    const state = location.state as OcrReviewState | null;

    const imageUrl = state?.imageUrl;
    const fileName = state?.fileName;
    const dispenserUnit = state?.dispenserUnit ?? 'DU-01';
	const dispenserSide = state?.dispenserSide ?? 'A';
    const receiptType = state?.receiptType ?? 'START Receipt';
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
          OCR Review
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
          sx={{ mt: 0.5 }}
        >
          Review the extracted receipt information before confirming.
        </Typography>
      </Box>

      <Paper
        elevation={0}
        sx={{
          p: 2,
          border: 1,
          borderColor: 'divider',
          borderRadius: 2,
        }}
      >
        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              lg: '1fr 1.1fr',
            },
            gap: 3,
          }}
        >
		<Box>
		  <Typography
		    variant="h6"
		    sx={{
		      color: 'primary.dark',
		      fontWeight: 700,
		      mb: 1.5,
		    }}
		  >
		    Receipt Image
		  </Typography>

		  <Box
		    sx={{
		      minHeight: {
		        xs: 220,
		        lg: 360,
		      },
		      display: 'flex',
		      alignItems: 'center',
		      justifyContent: 'center',
		      overflow: 'hidden',
		      border: 1,
		      borderStyle: 'dashed',
		      borderColor: 'divider',
		      borderRadius: 2,
		      backgroundColor: 'background.default',
		    }}
		  >
		    {imageUrl ? (
		      <Box
		        component="img"
		        src={imageUrl}
		        alt="Receipt preview"
		        sx={{
		          width: '100%',
		          height: '100%',
		          maxHeight: {
		            xs: 320,
		            lg: 360,
		          },
		          objectFit: 'contain',
		        }}
		      />
		    ) : (
		      <Stack
		        spacing={1}
		        sx={{
		          alignItems: 'center',
		          textAlign: 'center',
		        }}
		      >
		        <ImageOutlinedIcon
		          sx={{
		            fontSize: 48,
		            color: 'text.secondary',
		          }}
		        />

		        <Typography
		          variant="body1"
		          sx={{
		            fontWeight: 600,
		          }}
		        >
		          Receipt Preview
		        </Typography>

		        <Typography
		          variant="body2"
		          color="text.secondary"
		        >
		          No receipt image is available.
		        </Typography>
		      </Stack>
		    )}
		  </Box>

		  {fileName && (
		    <Typography
		      variant="caption"
		      color="text.secondary"
		      sx={{
		        display: 'block',
		        mt: 1,
		      }}
		    >
		      Selected file: {fileName}
		    </Typography>
		  )}
		</Box>
          <Box>
            <Typography
              variant="h6"
              sx={{
                color: 'primary.dark',
                fontWeight: 700,
                mb: 1.5,
              }}
            >
              Extracted Reading
            </Typography>

            <Stack spacing={2}>
              <Box
                sx={{
                  display: 'grid',
                  gridTemplateColumns: {
                    xs: '1fr',
                    sm: 'repeat(2, minmax(0, 1fr))',
                  },
                  gap: 2,
                }}
              >
                <Box>
                  <Typography
                    variant="caption"
                    color="text.secondary"
                  >
                    Dispenser Unit
                  </Typography>

                  <Typography
                    variant="body1"
                    sx={{ fontWeight: 600 }}
                  >
                    {dispenserUnit} ({dispenserSide})
                  </Typography>
                </Box>

                <Box>
                  <Typography
                    variant="caption"
                    color="text.secondary"
                  >
                    Receipt Type
                  </Typography>

                  <Typography
                    variant="body1"
                    sx={{ fontWeight: 600 }}
                  >
                    {receiptType}
                  </Typography>
                </Box>
              </Box>

              <Paper
                elevation={0}
                sx={{
                  p: 2,
                  border: 1,
                  borderColor: 'divider',
                  borderRadius: 2,
                }}
              >
                <Stack spacing={1.5}>
                  <Box
                    sx={{
                      display: 'flex',
                      justifyContent: 'space-between',
                      alignItems: 'center',
                    }}
                  >
                    <Typography
                      variant="subtitle1"
                      sx={{ fontWeight: 700 }}
                    >
                      N1 - Petrol
                    </Typography>

                    <Chip
                      label="High Confidence"
                      size="small"
                      icon={<CheckCircleOutlineOutlinedIcon />}
                    />
                  </Box>

                  <TextField
                    label="Extracted Reading"
                    defaultValue="1049803.82"
                    fullWidth
                  />
                </Stack>
              </Paper>

              <Paper
                elevation={0}
                sx={{
                  p: 2,
                  border: 1,
                  borderColor: 'divider',
                  borderRadius: 2,
                }}
              >
                <Stack spacing={1.5}>
                  <Box
                    sx={{
                      display: 'flex',
                      justifyContent: 'space-between',
                      alignItems: 'center',
                    }}
                  >
                    <Typography
                      variant="subtitle1"
                      sx={{ fontWeight: 700 }}
                    >
                      N2 - Diesel
                    </Typography>

                    <Chip
                      label="High Confidence"
                      size="small"
                      icon={<CheckCircleOutlineOutlinedIcon />}
                    />
                  </Box>

                  <TextField
                    label="Extracted Reading"
                    defaultValue="732984.77"
                    fullWidth
                  />
                </Stack>
              </Paper>
            </Stack>
          </Box>
        </Box>
      </Paper>

      <Box
        sx={{
          display: 'flex',
          flexDirection: {
            xs: 'column',
            sm: 'row',
          },
          justifyContent: 'space-between',
          gap: 1.5,
        }}
      >
        <Button
          variant="outlined"
          onClick={() => navigate('/app/receipts')}
        >
          Replace Image
        </Button>

        <Button
          variant="contained"
        >
          Confirm Reading
        </Button>
      </Box>
    </Stack>
  );
}

export default OcrReviewPage;