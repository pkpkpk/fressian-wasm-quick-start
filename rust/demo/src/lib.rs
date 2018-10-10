#![allow(unused_imports)]

#[macro_use]
extern crate serde_derive;

extern crate serde;
extern crate serde_fressian;

use std::fmt;
use serde::ser::{Serialize, Serializer, SerializeMap};

use serde_fressian::de::{self};
use serde_fressian::ser::{self};
use serde_fressian::error::{Error as FressError, ErrorCode};
use serde_fressian::value::{self, Value};
use serde_fressian::wasm::{self};

#[no_mangle]
pub extern "C" fn echo(ptr: *mut u8, len: usize) ->*mut u8
{
    let val: Result<Value, FressError> = wasm::from_ptr(ptr, len);
    wasm::fress_dealloc(ptr, len);
    wasm::to_js(val)
}


