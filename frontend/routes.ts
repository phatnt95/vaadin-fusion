import { Route } from '@vaadin/router';
import './views/contact/contact-view';
import './views/main-layout';

export type ViewRoute = Route & {
  title?: string;
  icon?: string;
  children?: ViewRoute[];
};

export const views: ViewRoute[] = [
  // place routes below (more info https://vaadin.com/docs/latest/fusion/routing/overview)
  {
    path: '',
    component: 'contact-view',
    icon: '',
    title: '',
  },
  {
    path: 'hello',
    component: 'contact-view',
    icon: 'la la-file',
    title: 'Contact',
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-layout',
    children: [...views],
  },
];
