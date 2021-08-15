import { NativeModules } from 'react-native';

type MultitaskBlurType = {
  blur: Function;
  unBlur: Function;
};

const { MultitaskBlur } = NativeModules;

export default MultitaskBlur as MultitaskBlurType;
