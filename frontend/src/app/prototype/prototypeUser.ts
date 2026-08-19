import type { UserRole } from '../../types/UserRole';

export type PrototypeUser = {
  name: string;
  stationName: string;
  role: UserRole;
};

export const prototypeUser: PrototypeUser = {
  name: 'Sujith',
  stationName: 'Demo Station',
  role: 'REVIEWER',
};