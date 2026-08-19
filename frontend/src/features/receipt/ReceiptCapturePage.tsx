import { useNavigate } from 'react-router';
import {
  Box,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Paper,
  Select,
  Stack,
  Typography,
} from '@mui/material';
import { useState } from 'react';
import ReceiptUploadCard from './components/ReceiptUploadCard';

function ReceiptCapturePage() {
	const navigate = useNavigate();
	const [selectedFile, setSelectedFile] = useState<File | null>(null);
	const [imageUrl, setImageUrl] = useState<string>();
	const [receiptType, setReceiptType] = useState('START');

	const handleImageSelected = (file: File) => {
	  setSelectedFile(file);

	  const reader = new FileReader();

	  reader.onload = () => {
	    if (typeof reader.result === 'string') {
	      setImageUrl(reader.result);
	    }
	  };

	  reader.readAsDataURL(file);
	};

	const handleImageRemoved = () => {
	  setSelectedFile(null);
	  setImageUrl(undefined);
	};

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
          Receipt Capture
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
          sx={{
            mt: 0.5,
          }}
        >
          Capture or select a receipt image and submit it for OCR processing.
        </Typography>
      </Box>

      <Paper
        elevation={0}
        sx={{
          p: 2,
          border: 1,
          borderColor: 'divider',
          borderRadius: 2,
          backgroundColor: 'background.paper',
        }}
      >
        <Typography
          variant="h6"
          sx={{
            fontWeight: 700,
            color: 'primary.dark',
            mb: 1.25,
          }}
        >
          Shift Context
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              md: 'repeat(4, minmax(0, 1fr))',
            },
            gap: 2,
          }}
        >
          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Employee
            </Typography>

            <Typography
              variant="body1"
              sx={{
                fontWeight: 600,
              }}
            >
              Sujith
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Station
            </Typography>

            <Typography
              variant="body1"
              sx={{
                fontWeight: 600,
              }}
            >
              Demo Station
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Shift
            </Typography>

            <Typography
              variant="body1"
              sx={{
                fontWeight: 600,
              }}
            >
              Shift 1
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Working Time
            </Typography>

            <Typography
              variant="body1"
              sx={{
                fontWeight: 600,
              }}
            >
              06:00 - 14:00
            </Typography>
          </Box>
        </Box>
      </Paper>

	  <Paper
	    elevation={0}
	    sx={{
	      p: 2,
	      border: 1,
	      borderColor: 'divider',
	      borderRadius: 2,
	      backgroundColor: 'background.paper',
	    }}
	  >
	    <Typography
	      variant="h6"
	      sx={{
	        fontWeight: 700,
	        color: 'primary.dark',
	        mb: 1.25,
	      }}
	    >
	      Receipt Details
	    </Typography>

	    <Box
	      sx={{
	        display: 'grid',
	        gridTemplateColumns: {
	          xs: '1fr',
	          md: '1fr 1.5fr 1fr',
	        },
	        gap: 2,
	        alignItems: 'center',
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
	          sx={{
	            fontWeight: 600,
	          }}
	        >
	          DU-01 (A)
	        </Typography>
	      </Box>

	      <Box>
	        <Typography
	          variant="caption"
	          color="text.secondary"
	        >
	          Assigned Nozzles
	        </Typography>

	        <Typography
	          variant="body1"
	          sx={{
	            fontWeight: 600,
	          }}
	        >
	          N1 - Petrol, N2 - Diesel
	        </Typography>
	      </Box>

	      <FormControl fullWidth>
	        <InputLabel id="receipt-type-label">
	          Receipt Type
	        </InputLabel>

			<Select
			  labelId="receipt-type-label"
			  label="Receipt Type"
			  value={receiptType}
			  onChange={(event) => setReceiptType(event.target.value)}
			>
	          <MenuItem value="START">
	            START Receipt
	          </MenuItem>

	          <MenuItem value="END">
	            END Receipt
	          </MenuItem>
	        </Select>
	      </FormControl>
	    </Box>
	  </Paper>

	  <ReceiptUploadCard
	    title="Receipt Image"
	    description="Ensure that the printed reading is clearly visible before submitting the image."
	    imageUrl={imageUrl}
	    fileName={selectedFile?.name}
	    onImageSelected={handleImageSelected}
	    onImageRemoved={handleImageRemoved}
	  />

      <Box
        sx={{
          display: 'flex',
          justifyContent: 'flex-end',
        }}
      >
	  <Button
	    variant="contained"
	    size="large"
	    disabled={!selectedFile || !imageUrl}
	    onClick={() =>
	      navigate('/app/receipts/ocr-review', {
			state: {
			  imageUrl,
			  fileName: selectedFile?.name,
			  dispenserUnit: 'DU-01',
			  dispenserSide: 'A',
			  receiptType:
			    receiptType === 'START'
			      ? 'START Receipt'
			      : 'END Receipt',
			},
	      })
	    }
	    sx={{
	      minWidth: {
	        xs: '100%',
	        sm: 220,
	      },
	    }}
	  >
	    Submit for OCR
	  </Button>
      </Box>
    </Stack>
  );
}

export default ReceiptCapturePage;