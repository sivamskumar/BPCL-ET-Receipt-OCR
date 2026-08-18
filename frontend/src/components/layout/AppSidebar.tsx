import { useState } from 'react';

import ExpandLessOutlinedIcon from '@mui/icons-material/ExpandLessOutlined';
import ExpandMoreOutlinedIcon from '@mui/icons-material/ExpandMoreOutlined';

import {
  Box,
  Collapse,
  List,
  ListItemButton,
  ListItemIcon,
  ListItemText,
} from '@mui/material';

import { useLocation, useNavigate } from 'react-router';

import {
  navigationItems,
  type NavigationEntry,
  type NavigationGroup,
  type NavigationItem,
} from '../../app/navigation/navigationConfig';

import { prototypeUser } from '../../app/prototype/prototypeUser';

function AppSidebar() {
  const navigate = useNavigate();
  const location = useLocation();

  const [openGroups, setOpenGroups] = useState<string[]>([]);

  const allowedNavigationItems = navigationItems.filter((entry) =>
    entry.roles.includes(prototypeUser.role),
  );

  const isItemSelected = (item: NavigationItem) =>
    location.pathname === item.path;

  const isGroupSelected = (group: NavigationGroup) =>
    group.children.some((child) => location.pathname === child.path);

  const isGroupOpen = (group: NavigationGroup) =>
    openGroups.includes(group.label) || isGroupSelected(group);

  const toggleGroup = (group: NavigationGroup) => {
    setOpenGroups((currentGroups) => {
      if (currentGroups.includes(group.label)) {
        return currentGroups.filter(
          (groupLabel) => groupLabel !== group.label,
        );
      }

      return [...currentGroups, group.label];
    });
  };

  const renderNavigationItem = (
    item: NavigationItem,
    nested = false,
  ) => {
    const selected = isItemSelected(item);

    return (
      <ListItemButton
        key={item.path}
        selected={selected}
        onClick={() => navigate(item.path)}
        sx={{
          mb: 0.5,
          pl: nested ? 4.5 : 2,
          borderRadius: 1.5,
          color: 'inherit',

          '& .MuiListItemIcon-root': {
            color: 'inherit',
          },

          '&.Mui-selected': {
            backgroundColor: 'secondary.main',
            color: 'secondary.contrastText',
          },

          '&.Mui-selected:hover': {
            backgroundColor: 'secondary.dark',
          },

          '&:hover': {
            backgroundColor: 'rgba(255, 255, 255, 0.08)',
          },
        }}
      >
        <ListItemIcon
          sx={{
            minWidth: 40,
          }}
        >
          {item.icon}
        </ListItemIcon>

        <ListItemText
          primary={item.label}
          slotProps={{
            primary: {
              sx: {
                fontWeight: selected ? 700 : 500,
              },
            },
          }}
        />
      </ListItemButton>
    );
  };

  const renderNavigationGroup = (group: NavigationGroup) => {
    const open = isGroupOpen(group);
    const selected = isGroupSelected(group);

    return (
      <Box key={group.label}>
        <ListItemButton
          onClick={() => toggleGroup(group)}
          sx={{
            mb: 0.5,
            borderRadius: 1.5,
            color: 'inherit',

            '& .MuiListItemIcon-root': {
              color: 'inherit',
            },

            '&:hover': {
              backgroundColor: 'rgba(255, 255, 255, 0.08)',
            },
          }}
        >
          <ListItemIcon
            sx={{
              minWidth: 40,
            }}
          >
            {group.icon}
          </ListItemIcon>

          <ListItemText
            primary={group.label}
            slotProps={{
              primary: {
                sx: {
                  fontWeight: selected ? 700 : 500,
                },
              },
            }}
          />

          {open ? (
            <ExpandLessOutlinedIcon />
          ) : (
            <ExpandMoreOutlinedIcon />
          )}
        </ListItemButton>

        <Collapse
          in={open}
          timeout="auto"
          unmountOnExit
        >
          <List
            component="div"
            disablePadding
          >
            {group.children
              .filter((child) =>
                child.roles.includes(prototypeUser.role),
              )
              .map((child) =>
                renderNavigationItem(child, true),
              )}
          </List>
        </Collapse>
      </Box>
    );
  };

  const renderNavigationEntry = (
    entry: NavigationEntry,
  ) => {
    if (entry.type === 'group') {
      return renderNavigationGroup(entry);
    }

    return renderNavigationItem(entry);
  };

  return (
    <Box
      component="aside"
      sx={{
        width: 260,
        flexShrink: 0,
        backgroundColor: 'primary.dark',
        color: 'primary.contrastText',
      }}
    >
      <List
        sx={{
          px: 1.5,
          py: 2,
        }}
      >
        {allowedNavigationItems.map((entry) =>
          renderNavigationEntry(entry),
        )}
      </List>
    </Box>
  );
}

export default AppSidebar;