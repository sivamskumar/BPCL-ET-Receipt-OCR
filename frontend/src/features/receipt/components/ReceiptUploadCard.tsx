import CameraAltOutlinedIcon from '@mui/icons-material/CameraAltOutlined';
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';

import {
  Box,
  Button,
  Paper,
  Stack,
  Typography,
} from '@mui/material';

import { useRef } from 'react';

type ReceiptUploadCardProps = {
  title: string;
  description: string;
  imageUrl?: string;
  fileName?: string;
  onImageSelected: (file: File) => void;
  onImageRemoved: () => void;
};

function ReceiptUploadCard({
  title,
  description,
  imageUrl,
  fileName,
  onImageSelected,
  onImageRemoved,
}: ReceiptUploadCardProps) {
  const fileInputRef = useRef<HTMLInputElement>(null);

  const handleChooseImage = () => {
    fileInputRef.current?.click();
  };

  const handleFileChange = (
    event: React.ChangeEvent<HTMLInputElement>,
  ) => {
    const file = event.target.files?.[0];

    if (file) {
      onImageSelected(file);
    }

    event.target.value = '';
  };

  return (
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
      <Stack spacing={2}>
        <Box>
          <Typography
            variant="h6"
            sx={{
              fontWeight: 700,
              color: 'primary.dark',
            }}
          >
            {title}
          </Typography>

          <Typography
            variant="body2"
            color="text.secondary"
            sx={{
              mt: 0.25,
            }}
          >
            {description}
          </Typography>
        </Box>

        <Box
          sx={{
            minHeight: {
              xs: 150,
              md: 150,
            },
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            overflow: 'hidden',
            border: 1,
            borderStyle: imageUrl ? 'solid' : 'dashed',
            borderColor: 'divider',
            borderRadius: 2,
            backgroundColor: 'background.default',
          }}
        >
          {imageUrl ? (
            <Box
              component="img"
              src={imageUrl}
              alt="Selected receipt preview"
              sx={{
                width: '100%',
                maxHeight: 260,
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
                No receipt selected
              </Typography>

              <Typography
                variant="body2"
                color="text.secondary"
              >
                Capture a photo or select an existing image.
              </Typography>
            </Stack>
          )}
        </Box>

        {fileName && (
          <Typography
            variant="caption"
            color="text.secondary"
          >
            Selected file: {fileName}
          </Typography>
        )}

        <input
          ref={fileInputRef}
          type="file"
          accept="image/*"
          hidden
          onChange={handleFileChange}
        />

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(2, minmax(0, 1fr))',
            },
            gap: 1.5,
          }}
        >
          <Button
            variant="contained"
            startIcon={<CameraAltOutlinedIcon />}
            onClick={handleChooseImage}
          >
            Take Photo
          </Button>

          <Button
            variant="outlined"
            startIcon={<ImageOutlinedIcon />}
            onClick={handleChooseImage}
          >
            {imageUrl ? 'Replace Image' : 'Choose Image'}
          </Button>
        </Box>

		{imageUrl && (
		  <Button
		    variant="outlined"
		    color="error"
		    onClick={onImageRemoved}
		    sx={{
		      alignSelf: 'flex-start',
		    }}
		  >
		    Remove Image
		  </Button>
		)}
      </Stack>
    </Paper>
  );
}

export default ReceiptUploadCard;