﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Laser : MonoBehaviour
{
    private float _speed = 8.0f;

    void Update()
    {
        transform.Translate(Vector3.up * _speed * Time.deltaTime);  

        if (transform.position.y > 7.0f)
        {
            Destroy(this.gameObject);

        }
    }
}
