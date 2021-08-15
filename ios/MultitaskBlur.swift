//
//  MultitaskBlur.swift
//  MultitaskBlur
//
//  Created by Raden on 15/August/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation

@objc(MultitaskBlur)
class MultitaskBlur : NSObject {
    @objc static func requiresMainQueueSetup() -> Bool {
        return false
    }
  
    @objc func blur() -> Void {
      let data:[String: Int] = ["isBlur": 1]
      NotificationCenter.default.post(name: NSNotification.Name("onBlur"), object: nil, userInfo: data)
    }
  
    @objc func unBlur() -> Void {
      let data:[String: Int] = ["isBlur": 0]
      NotificationCenter.default.post(name: NSNotification.Name("onBlur"), object: nil, userInfo: data)
    }
}
