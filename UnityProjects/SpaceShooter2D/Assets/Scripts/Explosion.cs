using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Explosion : MonoBehaviour
{
    private Player _player;

    void Start()
    {
        Destroy(this.gameObject, 2.38f);

        _player = GameObject.Find("Player").GetComponent<Player>();

        if(_player == null)
        {
            Debug.LogError("Player not found.");

        }

    }

}
